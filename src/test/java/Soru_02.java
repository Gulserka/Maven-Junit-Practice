import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_02 {
    /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    1-Then new butonuna basar
    2-And editor firstname kutusuna "<firstName>" bilgileri girer
    3-And editor lastname kutusuna "<lastName>" bilgileri girer
    4-And editor position kutusuna "<position>" bilgileri girer
    5-And editor office kutusuna "<office>" bilgileri girer
    6-And editor extension kutusuna "<extension>" bilgileri girer
    7-And editor startdate kutusuna "<startDate>" bilgileri girer
    8-And editor salary kutusuna "<salary>" bilgileri girer
    9-When Create tusuna basar
    10-Then Kullanıcının eklendiğini doğrular.
    11-And Eklediği kullanıcı kaydını siler
    12-Then Kullanıcinin silindiğini doğrular.
    */
    static WebDriver driver;
    @BeforeClass
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://editor.datatables.net/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).
                sendKeys("Ali", Keys.TAB,
                        "CAN", Keys.TAB,
                        "QA", Keys.TAB,
                        "Turkey", Keys.TAB,
                        "Dev", Keys.TAB,
                        "1998-09-05", Keys.TAB,
                        "1500", Keys.TAB);
//       driver.findElement(By.xpath("//*[text()='September']")).click();
//       driver.findElement(By.xpath("//*[text()='1998']")).click();
//       driver.findElement(By.xpath("//*[text()='5']")).click();
        //      driver.findElement(By.xpath("//*[@id='DTE_Field_salary']")).sendKeys("1500");
        driver.findElement(By.xpath("//*[@class='btn']")).click();
    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Ali CAN",Keys.ENTER);
        WebElement arama = driver.findElement(By.xpath("//*[text()='Ali CAN']"));
        Assert.assertTrue(arama.isDisplayed());
        if(!arama.isSelected()){
            arama.click();
        }
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Ali CAN",Keys.ENTER);
        WebElement yazi= driver.findElement(By.xpath("//*[text()='No matching records found']"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
