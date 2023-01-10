package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Day12_Challenge2_Hover0ver extends TestBase {



    @Test
    public void test01(){

        ////1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);

        //    //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMe = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        actions.moveToElement(hoverOverMe).perform();

        //    //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("//*[.='Link 1']")).click();

        //    //4. Popup mesajini yazdirin
        driver.switchTo().alert().getText();
        waitFor(2);

        //    //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //    //6. "Click and hold" kutusuna basili tutun
        WebElement clickHold = driver.findElement(By.xpath("//p[.='Click and Hold!']"));
        actions.clickAndHold(clickHold).perform();


        //    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        driver.findElement(By.xpath("//*[.='Well done! keep holding that click now.....']")).getText();

        //    //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.xpath("//*[@id='double-click']"));
        System.out.println("tiklamadanOnce = " + doubleClickMe);
        actions.doubleClick(doubleClickMe).perform();

        //    //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String doubleClickMeRenk = doubleClickMe.getAttribute("class");
        System.out.println("tiklamadanSonra = " + doubleClickMeRenk);
        Assert.assertNotEquals(doubleClickMeRenk,doubleClickMe);




    }












}
