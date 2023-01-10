package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class Soru_12 extends TestBase {


    @Test
    public void test01() throws InterruptedException, AWTException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();


        //5. Hover over first product and click 'Add to cart'
        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[.='Continue Shopping']")).click();

        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@data-product-id='2'])[1]")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[.='View Cart'])[1]")).click();


        //9. Verify both products are added to Cart
        WebElement product1 = driver.findElement(By.xpath("//*[@id='product-1']"));
        Assert.assertTrue(product1.isDisplayed());
        WebElement product2 = driver.findElement(By.xpath("//*[@id='product-2']"));
        Assert.assertTrue(product2.isDisplayed());

        //10. Verify their prices, quantity and total price
        WebElement price1 = driver.findElement(By.xpath("(//td[@class='cart_price'])[1]"));
        Assert.assertTrue(price1.isDisplayed());
        WebElement quantity1 = driver.findElement(By.xpath("(//*[@class='cart_quantity'])[1]"));
        Assert.assertTrue(quantity1.isDisplayed());
        WebElement totalPrice1 = driver.findElement(By.xpath("(//*[@class='cart_total'])[1]"));
        Assert.assertTrue(totalPrice1.isDisplayed());

        WebElement price2 = driver.findElement(By.xpath("(//*[@class='cart_price'])[2]"));
        Assert.assertTrue(price2.isDisplayed());
        WebElement quantity2 = driver.findElement(By.xpath("//*[@class='cart_quantity']"));
        Assert.assertTrue(quantity2.isDisplayed());
        WebElement totalPrice2 = driver.findElement(By.xpath("(//*[@class='cart_total'])[2]"));
        Assert.assertTrue(totalPrice2.isDisplayed());


    }







}
