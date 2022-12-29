package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_04 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Logout' button
    //10. Verify that user is navigated to login page
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test01(){
        //3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/",actualUrl);
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //driver.findElement(By.linkText("//*[@href=\"/login\"]"));
        //5. Verify 'Login to your account' is visible
        WebElement login = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());
        //6. Enter correct email address and password
        // 7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type=\"email\"])[1]")).sendKeys("ahmet@nehab1er.com", Keys.TAB, "12345", Keys.ENTER);
        ////*[@type="email"]
        //8. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//*[@class=\"fa fa-user\"]"));
        Assert.assertTrue(logged.isDisplayed());
        System.out.println(logged.getText());
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
        //10. Verify that user is navigated to login page
        String actualLoginUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/login";
        Assert.assertEquals(expectedUrl,actualLoginUrl);
        String deneme= " \"logout\" yazısını kontrol et ";
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
