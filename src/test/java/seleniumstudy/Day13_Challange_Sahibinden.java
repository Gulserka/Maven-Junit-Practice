package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Day13_Challange_Sahibinden extends TestBase {

    @Test
    public void test01() {

        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com/");

        //anasayfada oldugunuzu dogrulayin
        WebElement anasayfa = driver.findElement(By.id("secure-login"));
        Assert.assertTrue(anasayfa.isDisplayed());

        //detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();

        //detayli arama sayfasina geldiginizi dogrulatin
        WebElement detayliArama = driver.findElement(By.xpath("//*[@class='categoryWrapper']"));
        Assert.assertTrue(detayliArama.isDisplayed());

        //emlak-konut-satilik seceneklerini secip
        waitFor(3);
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();//cerez
        driver.findElement(By.xpath("//*[.='Emlak']")).click();
        driver.findElement(By.xpath("//*[.='Konut']")).click();
        driver.findElement(By.xpath("//*[.='Satılık']")).click();
        driver.findElement(By.xpath("//span[text()='Daire']")).click();
        waitFor(3);


        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        //filtreler için sağıdakilere benzer methodlar oluşturun
        //    detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
        //    detayli_Arama_Fiyat("4.000","4.000.000","USD");
        //    detayli_Arama_Brut("180","400");
        //    detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi...
        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin


        detayli_Arama_Adres("İzmir", "Bayraklı", "Manavkuyu Mah.");
        waitFor(2);
        detayliAramaFiyat("4000", "4000000", "USD");
        waitFor(2);
        detayliAramaBrut("180", "400");
        waitFor(2);
        detayliAramaOdaSayisi("10 Üzeri");

        driver.findElement(By.xpath("//*[.='Arama Yap']")).click();
        String sonuc =driver.findElement(By.xpath("//*[@class='result-text']")).getText();
        System.out.println(sonuc);

    }

    public void detayli_Arama_Adres(String il, String ilce, String mahalle) {
        WebElement il1 = driver.findElement(By.xpath("//*[@class='faceted-select']"));
        il1.click();
        driver.findElement(By.xpath("//input[@placeholder='İl']")).sendKeys(il);
        driver.findElement(By.xpath("(//*[.='İzmir'])[2]")).click();


        WebElement ilce1 = driver.findElement(By.xpath("//*[@title='İlçe']"));
        ilce1.click();
        driver.findElement(By.xpath("//*[@placeholder='İlçe']")).sendKeys(ilce);
        WebElement ilceButon = driver.findElement(By.xpath("(//*[@class='noChild facetedCheckbox'])[4]"));
        ilceButon.click();

        driver.findElement(By.xpath("(//*[@href='#'])[13]")).click();

        WebElement mahalle1 = driver.findElement(By.xpath("//*[@title='Mahalle']"));
        mahalle1.click();
        driver.findElement(By.xpath("(//*[@class=' facetedCheckbox'])[15]")).click();
        waitFor(1);
        driver.findElement(By.xpath("//*[@class='collapse-pane']")).click();
    }

    public void detayliAramaFiyat(String min, String max, String tl) {
        //    detayli_Arama_Fiyat("4.000","4.000.000","USD");

        driver.findElement(By.xpath("//*[@placeholder='Min TL']")).sendKeys(min);
        driver.findElement(By.xpath("//*[@placeholder='Max TL']")).sendKeys(max);
        WebElement price = driver.findElement(By.xpath("//*[@name='price_currency']"));
        price.click();
        Select select = new Select(price);
        select.selectByVisibleText(tl);

    }

    public void detayliAramaBrut(String min, String max) {

        //    detayli_Arama_Brut("180","400");
        WebElement brut = driver.findElement(By.xpath("//*[@name='a24_min']"));
        brut.sendKeys(min, Keys.TAB, max);

    }

    public void detayliAramaOdaSayisi(String odaSayiSecenek) {

        //    detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi...
        WebElement odaSayisi = driver.findElement(By.xpath("(//*[@class='filtered-select closed js-filtered-select'])[1]"));
        odaSayisi.click();
        WebElement odaButon = driver.findElement(By.xpath("(//*[@class='js-select-filter'])[1]"));
        odaButon.sendKeys(odaSayiSecenek);
        driver.findElement(By.xpath("//*[@for='a20_option_43']")).click();


    }



}
