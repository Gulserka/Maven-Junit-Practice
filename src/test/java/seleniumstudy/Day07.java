package seleniumstudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day07 {

     /*

        1-https://books-pwakit.appspot.com/ adresine gidin.
        2-"BOOKS" başlığının görünür olduğunu doğrulayın
        3-Arama çubuğunda "Selenium" u aratın.
        4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
*/

    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://books-pwakit.appspot.com/");
    }
//    @After
//    public void close(){
//        driver.close();
//    }

    @Test
    public void Test01(){
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "BOOKS";
//        Assert.assertEquals(actualTitle,expectedTitle);
//        driver.findElement(By.xpath("//*[@id='input']"));

        WebElement headerElement = driver.findElement(By.id("books-header"));
        if (headerElement.isDisplayed()) {
            System.out.println("BOOKS header is displayed");
        } else {
            System.out.println("BOOKS header is not displayed");
        }


    }







}
