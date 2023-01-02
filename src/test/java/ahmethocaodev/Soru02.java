package ahmethocaodev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru02 {

    //1)http://demo.guru99.com/test/guru99home/sitesine gidiniz

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.guru99.com/test/guru99home/");
    }
    @Test
    public void test01(){
        //2)sayfadaki iframe sayısını bulunuz.
        int iframeSayisi = driver.findElements(By.xpath("//iframe")).size();
        System.out.println("iframeSayisi = " + iframeSayisi);

        //3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(0);
        //driver.findElement(By.xpath("//*[@href='https://www.youtube.com/watch?v=RbSlW8jZFe8&feature=emb_imp_woyt']")).click();



        //4)ilk iframe'den çıkıp ana sayfaya dönünüz
        //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız

    }





}
