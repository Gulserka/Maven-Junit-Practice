package selenium_study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_04 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();

        Thread.sleep(2000);
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(2000);
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement urunSepetteMi = driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        if (urunSepetteMi.isDisplayed()){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //9. Sayfayi kapatin
        driver.close();



    }
}
