package pdf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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
import java.util.ArrayList;
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
    public void test1() {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        int actualoptions = select.getOptions().size();
        int expectedoptions = 28;
        Assert.assertEquals(expectedoptions, actualoptions);

    }

    @Test
    public void test2() {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Books");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        String sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        List<String> sonucYazisiList = new ArrayList<>(Arrays.asList(sonucYazisi.replaceAll("[\\p{Punct}]", "").split(" ")));
        System.out.println(sonucYazisiList);
        System.out.println(sonucYazisiList.get(3));
        Assert.assertTrue(sonucYazisiList.contains(("Java"))); //we can also remove "[\\p{Punct}]" and put contains.("\"Java\"") like this:
        //Assert.assertTrue(sonucYazisiList.contains(("\"Java\"")));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}



