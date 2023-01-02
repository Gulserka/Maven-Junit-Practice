package pdf;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class Soru12 extends TestBase {


    @Test
    public void test01(){
        //●https://the-internet.herokuapp.com/windows adresinegidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //●Sayfadaki textin “Opening a new window” olduğunudoğrulayın.
        String text = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Opening a new window", text);


        //●Sayfa başlığının(title) “The Internet” olduğunudoğrulayın.
        String title = driver.getTitle();
        Assert.assertEquals("The Internet", title);

        //●Click Here butonunabasın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunudogrulayin.
// **************burda ilk yapmaya calistigim sey driver.switchTo idi. Ama o bos bir tab acmaya yariyor.
//***************click yaptigimiz yer yeni tab aciyorsa o zaman for dongusunu kullaniriz

        String ilkPencere = driver.getWindowHandle();
        Set<String> ikinciPencere = driver.getWindowHandles();
        for (String w : ikinciPencere) {
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(expectedTitle2,actualTitle2);


        //●Sayfadaki textin “New Window” olduğunudoğrulayın.
        String textNewWindow = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("New Window",textNewWindow);

        //●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkPencere);
        String ilkPencereTitle = driver.getTitle();
        Assert.assertEquals("The Internet",ilkPencereTitle);
    }








}
