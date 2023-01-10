package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class aaa extends TestBase {

    ///*
    //       url'ye git: http://demo.guru99.com/popup.php
    @Test
    public void test01(){
        driver.get("http://demo.guru99.com/popup.php");

        //       ilk pencereyi al
        String ilkPencere = driver.getWindowHandle();


        //       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("(//*[.='Click Here'])[2]")).click();

        //       setteki tüm pencereyi al
        Set<String> tumPencereler = driver.getWindowHandles();


        //       diğer pencereye geç
        for (String w : tumPencereler) {
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }

        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        //       Gönder düğmesine tıklayarak
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("somepne@gmail.com", Keys.ENTER);


        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String yazi = driver.findElement(By.xpath("(//*[.='This access is valid only for 20 days.'])[2]")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",yazi);

        //       Tekrar ilk pencereye geç
        driver.switchTo().window(ilkPencere);

        //       İlk pencerede olduğunu doğrula
        WebElement first = driver.findElement(By.xpath("//*[@href='../articles_popup.php']"));
        Assert.assertTrue(first.isDisplayed());

        //      */

    }








}
