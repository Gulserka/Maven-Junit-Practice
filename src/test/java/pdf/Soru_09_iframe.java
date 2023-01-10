package pdf;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Soru_09_iframe extends TestBase {
    //● Bir class olusturun: IframeTest
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //○Text Box’a “Merhaba Dunya!” yazin.
    //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin.

    @Test
    public void Test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        iframeTest();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Merhaba Dunya!");

        driver.switchTo().defaultContent();
        WebElement altYazi = driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']"));
        Assert.assertTrue(altYazi.isDisplayed());
        System.out.println("alt yazi = " + altYazi.getText());



    }

    public static void iframeTest(){
        String yazi = driver.findElement(By.tagName("h3")).getText();
        System.out.println("yazi = " + yazi);



    }










}
