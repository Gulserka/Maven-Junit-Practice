package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class ddd extends TestBase {

    @Test
    public void test01(){

        Actions actions = new Actions(driver);
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement playButton = driver.findElement(By.xpath("//*[@width='560']"));
        driver.switchTo().frame(playButton);
        waitFor(3);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


        //videoyu calistirdiginizi test edin
        WebElement play = driver.findElement(By.xpath("//*[@title='youtube.com sitesinde izle']"));
        Assert.assertTrue(play.isDisplayed());
    }

}
