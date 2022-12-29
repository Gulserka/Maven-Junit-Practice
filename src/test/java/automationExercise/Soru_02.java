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
import java.time.Duration;
public class Soru_02 {
    WebDriver driver;
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Delete Account' button
    //10. Verify that 'ACCOUNT DELETED!' is visible
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
    //6. Doğru e-posta adresini ve şifreyi girin
    //7. 'Giriş' düğmesine tıklayın
    //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //9. 'Hesabı Sil' düğmesini tıklayın
    //10. 'HESAP SİLİNDİ!' görünür olduğunu doğrulayın
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
        WebElement anasayfa = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(anasayfa.isDisplayed());
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        WebElement girişYazısı = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(girişYazısı.isDisplayed());
        WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys("ahmet@nehab1er.com", Keys.TAB,"12345",Keys.TAB,Keys.ENTER);
        WebElement emailGorunum2 = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(emailGorunum2.isDisplayed());

    }
}