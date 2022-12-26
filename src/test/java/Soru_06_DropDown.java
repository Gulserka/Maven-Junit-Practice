import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Soru_06_DropDown {

    //Create a class: DropDown
    //Go to https://the-internet.herokuapp.com/dropdown.
    //Select Option 1using index and print
    //Select Option 2 using 2.Value and print
    //3. Select Option 1 using Visible Text and print
    //4.Print all dropdown values
    //5. Find the size of the Dropdown, True if the Dropdown has 4 items, then True in the console
    //Print false.

    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın.
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void Test01() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByValue("2");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");

        List<WebElement> dropdownValues = select.getOptions();
        for (WebElement w : dropdownValues) {
            System.out.println(w.getText());
        }
        System.out.println("***********************");
        if (select.getOptions().size()==4){
            System.out.println("True");
        }else System.out.println("False");
    }


}



