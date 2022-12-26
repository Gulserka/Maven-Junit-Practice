import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void test1() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());
    }
    @Test
    public void test2(){
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdown);
        List<WebElement> secenekler = select.getOptions();
//    for(WebElement w :secenekler){
//        System.out.println(w.getText());
        secenekler.stream().forEach(t-> System.out.println(t.getText()));
        System.out.println(secenekler.size());
        if(secenekler.size()==4){
            System.out.println("True");
        }else System.out.println("False");
// Assert.assertFalse(secenekler.size()==4);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}






