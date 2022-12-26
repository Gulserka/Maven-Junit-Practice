package day04;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class C05_ClassWork {
    static WebDriver driver;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    public static void main(String[] args) {
        /*
     Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
     click on Phones & PDAs
     get the brandName of phones
     click on add to button for all elements
     click on black total added cart button
     get the names of list from the cart
     compare the names from displaying list and cart list
     */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home ");
        //     Telefonlar ve PDA'lar'a tıklayın
        driver.findElement(By.xpath("//*[@href='http://tutorialsninja.com/demo/index.php?route=product/category&path=24']")).click();
        //     telefonların markasını alın
        list1 = getName("//h4");
        System.out.println(list1);
        //     tüm öğeler için ekle düğmesine tıklayın
        allClick();
        //     siyah toplam eklenen sepet düğmesine tıklayın
        driver.findElement(By.id("cart-total")).click();
        //     listenin adlarını sepetten al
        String s1 =driver.findElement(By.xpath("//*[text()='HTC Touch HD']")).getText();
        String s2 =driver.findElement(By.xpath("//*[text()='iPhone']")).getText();
        String s3 =driver.findElement(By.xpath("//*[text()='Palm Treo Pro']")).getText();
        //     görüntüleme listesindeki ve alışveriş sepetindeki adları karşılaştırın
    }
    public static List<String> getName(String markalar) {
        List<String> list = new ArrayList<>();
        List<WebElement> webEl = driver.findElements(By.xpath("//h4"));
        webEl.forEach(t-> list.add(t.getText()));
        return list;
    }
    public static void allClick (){
        for (int i = 1; i <= list1.size(); i++) {
            driver.findElement(By.xpath("(//*[.='Add to Cart'])[" + i + "]")).click();
        }
    }
}