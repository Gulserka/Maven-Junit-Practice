package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class ccc extends TestBase {

    @Test
    public void test01(){
        ///*
        //   https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //   Title'in "Windows" oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(expectedTitle,actualTitle);

        //   Click here a tiklayin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        //   Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin

        String ilkPencere = driver.getWindowHandle();
        Set<String> tumPencereler = driver.getWindowHandles();
        for (String w : tumPencereler) {
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }

        String yeniSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window",yeniSayfaTitle);

        //*/

    }








}
