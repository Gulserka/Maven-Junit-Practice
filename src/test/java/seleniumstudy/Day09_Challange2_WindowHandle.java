package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class Day09_Challange2_WindowHandle extends TestBase {

    @Test
    public void Test01(){
        //url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //  ilk pencereyi al
        String firstWindow = driver.getWindowHandle();

        // "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("(//*[.='Click Here'])[2]")).click();




        //setteki tüm pencereyi al



        //diğer pencereye geç

        Set<String> ikinciWindow = driver.getWindowHandles();
        System.out.println("ikinciWindow = " + ikinciWindow);
        for (String w : ikinciWindow) {
            if (!w.equals(firstWindow)){
                driver.switchTo().window(w);
                break;
            }
        }


        //e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com", Keys.ENTER);


        //Gönder düğmesine tıklayarak
        //This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actualText = driver.findElement(By.xpath("(//*[.='This access is valid only for 20 days.'])[2]")).getText();
        String expectedText = "This access is valid only for 20 days.";
        Assert.assertEquals(expectedText,(actualText));



        //Tekrar ilk pencereye geç
        driver.switchTo().window(firstWindow);
        //İlk pencerede olduğunu doğrula
        String actualWindow = driver.getCurrentUrl();
        String expectedWindow = "https://demo.guru99.com/popup.php";
        Assert.assertEquals(expectedWindow,actualWindow);


    }










}
