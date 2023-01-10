package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class sss extends TestBase {
    //Go to https://www.amazon.com.tr/
    //Search iPhone13 512
    //Check that the results are listed
    //Click iPhone13 at the top of the list
    //Log the following values for each size .Size information .Price .Color .Stock status
    //Isim - Renk - Stok - Boyut - Fiyat
    @Test
    public void TEST() {
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.xpath("//*[@name='accept']")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);

        String actualTxt =driver.findElement(By.xpath("(//*[@class='s-no-outline'])[1]")).getText();

        String expectedTxt ="iphone 13 512 için sonuçlar gösteriliyor";
        Assert.assertTrue(actualTxt.contains(expectedTxt));
        driver.findElement(By.id("a-autoid-0")).click();
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        waitFor(2);
        driver.findElement(By.xpath("//input[@name='5']")).click();
        driver.findElement(By.xpath("//*[@aria-labelledby='size_name_2-announce']")).click();
        waitFor(2);
        String PhoneModel =driver.findElement(By.xpath("(//td[@class='a-span9'])[2]")).getText();
        waitFor(2);
        String  Size =driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();
        waitFor(2);
        String Color =driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();
        waitFor(2);
        String Price = (driver.findElement(By.xpath("(//div[@class='a-section dimension-slot-info'])[7]")).getText());
        waitFor(2);
        String Stock =driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();
        waitFor(2);
        System.out.println(PhoneModel+"  "+"Size: "+Size+"\n Color: "+" "+Color+"   "+"Price :"+Price+"\n Stock : "+Stock );



    }

}

