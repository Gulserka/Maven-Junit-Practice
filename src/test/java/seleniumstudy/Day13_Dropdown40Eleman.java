package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13_Dropdown40Eleman extends TestBase {

    @Test
    public void test1() {

        //        Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

//
//        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement allKutusu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        allKutusu.click();
        Select select = new Select(allKutusu);
//        dropdown menude 40 eleman olduğunu doğrulayın
        int sayi = select.getOptions().size();
        System.out.println("sayi = " + sayi);
        Assert.assertEquals(28, sayi);
//         Test02
//        dropdown menuden elektronik bölümü seçin
//        WebElement  = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        // Select select1 = new Select();
        select.selectByVisibleText("Electronics");
//        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);
//        sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement text = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String t = text.getText();
        Assert.assertTrue(t.contains("iphone"));
//        ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//*[@class='s-image']")).click();
//        ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
        String baslik = driver.getTitle();
        String fiyat = driver.findElement(By.xpath("//*[@class='a-section a-spacing-none aok-align-center']")).getText();
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
//        Test03
//        yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow((WindowType.TAB));
        driver.get("https://www.amazon.com");
        waitFor(3);
//        dropdown'dan bebek bölümüne secin
        WebElement allKutusu1 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select1 = new Select(allKutusu1);
        select1.selectByVisibleText("Baby");
//        bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Bebek puset" + Keys.ENTER);
        String sonucYazisi = driver.findElement(By.xpath("//*[text()='1-16 of 22 results for']")).getText();
        List<String> sonucList = new ArrayList<>(Arrays.asList(sonucYazisi.split(" ")));
        System.out.println("sonucList.get(2) = " + sonucList.get(2));
//        sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(sonucYazisi.contains("puset"));
//        5-üçüncü ürüne relative locater kullanarak tıklayin
//        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
//
//
//        Test 4
//        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.xpath("//*[@class='nav-cart-icon nav-sprite']")).click();


    }
}