package pdf.screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.io.IOException;

public class Soru01 extends TestBase {

    @Test
    public void test01() throws IOException {

        //1amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        //2amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        takeScreenShotOfPage();

        //3- Nutella icin arama yapin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);

        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        takeScreenshotOfElement(driver.findElement(By.xpath("(//*[@data-index='1'])[1]")));




    }







}
