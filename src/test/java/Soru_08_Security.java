import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;

public class Soru_08_Security {

    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

    WebDriver driver;

    @Before

    //1. Go to http://zero.webappsecurity.com/
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");

    }
    @After
    public void close(){
        driver.close();
    }

    @Test
    public void Test01() {

        //2. Press the sign in button
        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();


        //3. Type "username" in the login box
        //4. Enter "password." in the password box. in summer
        //5. Press Sign in button
        WebElement signIn = driver.findElement(By.xpath("//*[@id='user_login']"));
        signIn.sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.ENTER);
        driver.navigate().back();


        //6. Go to Pay Bills page
        //7. Press the “Purchase Foreign Currency” key
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();


        //8. Select Eurozone from the "Currency" drop down menu
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");


        //9. Enter a number in the "amount" box
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("1234");


        ///10. Test that “US Dollars” is not selected
        WebElement usDollars = driver.findElement(By.xpath("(//*[@class='radio inline'])[2]"));
        if (!usDollars.isSelected()) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");


        //11. Select the “Selected currency” button
        //12. Press the “Calculate Costs” button then press the “purchase” button
        //13. “Foreign currency cash was successfully purchased.” Check that the text is written.
        driver.findElement(By.xpath("(//*[@style='padding-bottom: 8px'])[2]")).click();
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        WebElement yazi = driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertTrue(yazi.isDisplayed());


    }


}
