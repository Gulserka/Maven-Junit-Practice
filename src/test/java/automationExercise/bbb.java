package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class bbb extends TestBase {


    @Test
    public void test01(){

        ////https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");


        ////Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();

        ////""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement yazi = driver.findElement(By.xpath("//*[.='Please select an item from left to start practice.']"));
        Assert.assertTrue(yazi.isDisplayed());

        ////Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("(//*[.='Browser Windows'])[2]")).click();

        ////New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab.isDisplayed());

        ////New Tab butonuna click yap
        WebElement newTab1 = driver.findElement(By.xpath("//*[@id='tabButton']"));
        newTab1.click();

        ////Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula

        String ilkPencere = driver.getWindowHandle();
        Set<String> tumPencereler = driver.getWindowHandles();
        for (String w : tumPencereler) {
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }
        WebElement yeniTabYazi = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(yeniTabYazi.isDisplayed());

        ////İlk Tab'a geri dön
        driver.switchTo().window(ilkPencere);

        //////New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButon = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTabButon.isDisplayed());
    }




}
