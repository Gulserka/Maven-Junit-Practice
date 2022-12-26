
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_03 {

    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

    }
    @After
    public void close(){
        driver.close();
    }


    @Test
    public void Test01() {
        //~ click on Phones & PDAs
        //    ~ get the brandName of phones

        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();
        // String firstOne =driver.findElement(By.xpath("(//*[text()='HTC Touch HD'])[2]")).getText();
        String secondOne =driver.findElement(By.xpath("//*[text()='iPhone']")).getText();
        String thirdOne =driver.findElement(By.xpath("//*[text()='Palm Treo Pro']")).getText();


        //  ~ click on add to button for all elements
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]")).click();
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[3]")).click();


        // ~ click on black total added cart button
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();

        //~ get the names of list from the cart
        driver.findElement(By.xpath("(//*[text()='HTC Touch HD'])[1]"));
        driver.findElement(By.xpath("(//*[text()='Palm Treo Pro'])[1]"));
        driver.findElement(By.xpath("(//*[text()='iPhone'])[1]"));



        // ~ compare the names from displaying list and cart list
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();

    }


}
