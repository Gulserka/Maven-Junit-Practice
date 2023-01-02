package seleniumstudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day09_Challange_iframe {


        //1- go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        //2- maximize the web site

        WebDriver driver;
        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        }
        @Test
        public void test01(){
            //3- ikinci emojiye tıklayın
            driver.switchTo().frame(1);
            driver.findElement(By.xpath("//*[@href='#nature']")).click();

            //4- ikinci emoji altındaki tüm öğelere tıklayın

            List<WebElement> emoji = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
            for (WebElement w : emoji) {
                w.click();
            }

            //5- ana iframe'e geri dön
            driver.switchTo().defaultContent();

            //6- formu doldurun,(Formu istediğiniz metinlerle doldurun)
            //7- uygula butonuna tıklayın
            driver.findElement(By.xpath("(//*[@class='mdl-textfield__input'])[1]"))
                    .sendKeys("aaa", Keys.TAB,"bbb",Keys.TAB,"aaa", Keys.TAB,"bbb",Keys.TAB,"aaa", Keys.TAB,"bbb",Keys.TAB,"aaa", Keys.TAB,"bbb",Keys.TAB,"aaa",Keys.TAB,"bbb",Keys.TAB,"aaa",Keys.TAB,Keys.ENTER);
        }



    }


