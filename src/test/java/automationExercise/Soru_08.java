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

public class Soru_08 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'


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

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage = driver.findElement(By.xpath("//*[@id='search_product']"));
        Assert.assertTrue(productPage.isDisplayed());


        //6. The products list is visible
        WebElement productList = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(productList.isDisplayed());

        //7. Click on 'View Product' of first product
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class='choose']//a")).click();
        Thread.sleep(5000);
      //  driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        WebElement productDetails = driver.findElement(By.xpath("//*[@class='product-details']"));
        Assert.assertTrue(productDetails.isDisplayed());

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//*[.='Blue Top']"));
        WebElement category = driver.findElement(By.xpath("//*[.='Category: Women > Tops']"));
        WebElement price = driver.findElement(By.xpath("//*[.='Rs. 500']"));
        WebElement availability = driver.findElement(By.xpath("//*[.='Availability:']"));
        WebElement condition = driver.findElement(By.xpath("//*[.='Condition:']"));
        WebElement brand = driver.findElement(By.xpath("//*[.='Brand:']"));


    }
}