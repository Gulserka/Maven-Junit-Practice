package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

public class S24 extends TestBase {
    @Test
    public void Tes01() throws InterruptedException {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hover = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).perform();

        Thread.sleep(3000);
        //3. "Link 1" e tiklayin
        WebElement click = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        Thread.sleep(3000);
        click.click();
        //4. Popup mesajini yazdirin
        driver.switchTo().alert().getText();
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement kutu1 = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.clickAndHold(kutu1).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(kutu1.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickButon = driver.findElement(By.xpath("//*[.='Double Click Me!']"));
        actions.doubleClick(doubleClickButon).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        WebElement yesil = driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertTrue(yesil.isDisplayed());


    }
}

