package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day11_Challenge_MarketTask extends TestBase {


    @Test
    public void test01(){
        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();

        //Search iPhone13 512
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iPhone13 512", Keys.ENTER);

        //Check that the results are listed
        WebElement resultList = driver.findElement(By.xpath("//*[.=' için sonuçlar gösteriliyor']"));
        Assert.assertTrue(resultList.isDisplayed());


        //Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Log the following values for each size .
        //Size information .Price .Color .Stock status
        driver.findElement(By.xpath("(//*[@class='a-price-whole'])[6]"));



        //Isim - Renk - Stok - Boyut - Fiyat

    }



}
