package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Day10_Challange_WindowHandle extends TestBase {

    @Test
    public void Test01(){
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula

        WebElement yazi = driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(yazi.isDisplayed());


        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[.='Browser Windows']")).click();


        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButon = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTabButon.isDisplayed());

        //New Tab butonuna click yap
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        newTab.click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String firstWindow = driver.getWindowHandle();
        Set<String> siradaki =driver.getWindowHandles();
        for (String w : siradaki) {
            if (!w.equals(firstWindow)){
                driver.switchTo().window(w);
                break;
            }
        }
        WebElement newTabYazi = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        Assert.assertTrue(newTabYazi.isDisplayed());
        //İlk Tab'a geri dön
        driver.switchTo().window(firstWindow);

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTabButon.isDisplayed());







    }



}
