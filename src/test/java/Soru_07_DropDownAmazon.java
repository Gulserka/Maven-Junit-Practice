import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Soru_07_DropDownAmazon {

    //Create a class: C3_DropDownAmazon
    //● Go to https://www.amazon.com/.
    //- Test 1
    //The number of categories in the category menu next to the search box is 45.
    //test what you are
    //-Test 2
    //1. Select the Books option from the Category menu
    //2. Type Java in the search box and search
    //3. Print the number of results found
    //4. Test that the result contains the word Java


    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");


    }

    @Test
    public void Test01() {

        WebElement categorySize = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(categorySize);
        Assert.assertEquals(select.getOptions().size(),28);

        //this is my extension
        List<WebElement> actualCategorySize = select.getOptions();
        actualCategorySize.stream().forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void Test02() {


        WebElement categorySize = driver.findElement((By.id("searchDropdownBox")));
        Select select = new Select(categorySize);
        select.selectByVisibleText("Books");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        WebElement text = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
        System.out.println("text = " + text.getText());
        Assert.assertTrue(text.getText().contains("Java"));

    }


}



