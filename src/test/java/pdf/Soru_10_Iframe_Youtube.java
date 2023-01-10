package pdf;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Soru_10_Iframe_Youtube extends TestBase {


    @Test
    public void Test01() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        //2) sayfadaki iframe sayısını bulunuz.
        driver.get("http://demo.guru99.com/test/guru99home/");
        int iframeSayisi = driver.findElements(By.tagName("iframe")).size();
        //driver.switchTo().frame(0);


        //3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement requiredFrame = driver.findElement(By.xpath("//iframe[contains(@src,'https://www.youtube.com/embed/RbSlW8jZFe8')]"));
        driver.switchTo().frame(requiredFrame);
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        element.click();
        Thread.sleep(10000);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        driver.switchTo().frame("(//iframe)[3]");
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();

        String firstWindow = driver.getWindowHandle();
        Set<String> secondWindow = driver.getWindowHandles();
        for (String w : secondWindow) {
            if (!w.equals(firstWindow)){
                driver.switchTo().window(w);
                break;
            }
        }




    }









}
