package pdf.wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Soru01 extends TestBase {

    @Test
    public void test01(){

        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //Iki metod icin de asagidaki adimlari test edin.


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();


        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
      //  driver.findElement(By.xpath("//*[@id='message']"));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();


        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsBack.isDisplayed());

    }

}
