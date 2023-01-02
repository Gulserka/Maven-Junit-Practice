package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_06 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

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
        Assert.assertEquals(expectedUrl,actualUrl);

        driver.findElement(By.xpath("//*[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@href='/products']")).click();


        String productActualUrl = driver.getCurrentUrl();
        String productExpectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(productExpectedUrl,productActualUrl);

        WebElement productsList = driver.findElement(By.xpath("//*[@class='col-sm-9 padding-right']"));
        Assert.assertTrue(productsList.isDisplayed());


        driver.findElement(By.xpath("(//*[@style='color: brown;'])[1]")).click();


        String actualDetails = driver.getCurrentUrl();
        String expectedDetails = "https://automationexercise.com/product_details/1";
        Assert.assertEquals(actualDetails,expectedDetails);

        WebElement categoryBrand = driver.findElement(By.xpath("//*[@class='left-sidebar']"));
        WebElement productNameDetails = driver.findElement(By.xpath("//*[@class='product-information']"));

        Assert.assertTrue(categoryBrand.isDisplayed());
        Assert.assertTrue(productNameDetails.isDisplayed());

    }









}
