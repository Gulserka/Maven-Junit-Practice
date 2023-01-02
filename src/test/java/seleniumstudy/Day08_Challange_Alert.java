package seleniumstudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day08_Challange_Alert {





    //    go to url :http://demo.automationtesting.in/Alerts.html

    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //   "Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın

    //    accept Alert(I am an alert box!) and print alert on console
    //    Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.

    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //   "Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın

    //    cancel Alert  (Press a Button !)
    //    Alert'ü kapatın

    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    "Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.

    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).

    //    Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
    //    finally print on console this mesaaje "Hello TechproEducation How are you today"

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='#OKTab']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        driver.switchTo().alert().accept();





        driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        driver.switchTo().alert().sendKeys("Gulser");
        driver.switchTo().alert().accept();

        String actualText = driver.findElement(By.xpath("//*[text()='Hello Gulser How are you today']")).getText();
        String expectedText = "Gulser";
        Assert.assertTrue(actualText.contains(expectedText));


    }
















}
