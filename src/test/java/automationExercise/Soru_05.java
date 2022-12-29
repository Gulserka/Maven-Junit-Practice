package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class Soru_05 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test01() throws InterruptedException {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();

        WebElement getInTouch = driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());

        WebElement info = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        info.sendKeys("Ali", Keys.TAB, "ali@gmail.com", Keys.TAB, "Subject", Keys.TAB, "message", Keys.TAB);

        driver.findElement(By.xpath("(//*[@class='form-control'])[5]")).sendKeys("C:/Users/Asus/OneDrive/Masaüstü/ME.jpeg"); //bunun yanina enter diyince failed oluyo.


        driver.findElement(By.xpath("(//*[@class='form-group col-md-12'])[4]")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        WebElement success = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        Assert.assertTrue(success.isDisplayed());
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();


    }


}
