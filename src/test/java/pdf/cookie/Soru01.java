package pdf.cookie;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Soru01 extends TestBase {

    @Test
    public void test01(){

        //Yeni bir class olusturun : cookiesAutomation
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2-tum cookie’leri listeleyin
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println(allCookies);

        for (Cookie w : allCookies) {
            System.out.println(w.getName() + " " + w.getValue());
        }
        //allCookies.forEach(System.out::println);


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(allCookies.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin


        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin


        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie> allCookies2 = driver.manage().getCookies();


    }
























}
