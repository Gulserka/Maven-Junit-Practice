package pdf;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Soru_11_WindowHandle extends TestBase {



    @Test
    public void Test01(){
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String amazonBaslik = driver.getTitle();
        Assert.assertTrue(amazonBaslik.contains("Amazon"));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com/tr/");

        //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String techproBaslik = driver.getTitle();
        Assert.assertFalse(techproBaslik.contains("TECHPROEDUCATION"));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String walmartBaslik = driver.getTitle();
        Assert.assertTrue(walmartBaslik.contains("Walmart"));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon.com"));



    }












}
