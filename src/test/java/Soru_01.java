
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Soru_01 {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test01() {
        WebElement soru = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(soru.isDisplayed());
    }
    @Test
    public void test02() {
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
    }
    @Test
    public void test03() {
        WebElement sign = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(sign.isDisplayed());
    }
    @Test
    public void test04() {
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("derrmaan", Keys.TAB, "derrman@hootm.com", Keys.ENTER);
    }
    @Test
    public void test05(){
        WebElement account= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(account.isDisplayed());
    }
    @Test
    public void test06(){
        driver.findElement(By.xpath("//*[@id='id_gender1']"));
        driver.findElement(By.xpath("//*[@id='name']"))
                .sendKeys("",Keys.TAB,
                        "1234",Keys.TAB,
                        "12",Keys.TAB,
                        "August",Keys.TAB,
                        "1999",Keys.TAB);
        driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
        driver.findElement(By.xpath("//*[@id='first_name']"))
                .sendKeys("gulser",Keys.TAB,
                        "kayacan",Keys.TAB,
                        "kayacan inc",Keys.TAB,
                        "izmir",Keys.TAB,
                        "izmir",Keys.TAB,
                        "Isr",Keys.TAB,
                        "dsfv", Keys.TAB,
                        "hdgfd",Keys.TAB,
                        "hgdfbvd",Keys.TAB,
                        "gfbv",Keys.TAB,Keys.ENTER);

        //import org.openqa.selenium.Keys;
        //WebDriver driver = # Selenium webdriver nesnesi oluşturun
        //for (int i = 0; i < 10; i++) {
        //    driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
        //}


    }
}
