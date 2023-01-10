package ahmethocaodev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import com.github.javafaker.Faker;

import java.util.Date;

public class Day13_Faker extends TestBase {

    //Faker Kutuphanesi HOMEWORK
    //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
    //degerler uretmemize imkan tanir.
    //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.

    @Test
    public void test() {

        Faker faker = new Faker();
        String name = faker.name().firstName();
        String surName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        int date = faker.number().numberBetween(1,31);
        System.out.println(date);


        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        waitFor(2);
        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        driver.findElement(By.name("firstname")).sendKeys(name, Keys.TAB, surName, Keys.TAB, email);
        waitFor(2);
        //“email” onay kutusuna emaili tekrar yazin
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email,Keys.TAB,password);

        //Bir sifre girin
        WebElement passwordLocate = driver.findElement(By.xpath("driver.findElement(boolean)"));
        Select select = new Select(passwordLocate);
        select.selectByVisibleText(password);

        //Tarih icin gun secin
        WebElement day=driver.findElement(By.xpath("//*[@id='day']"));
        select.selectByVisibleText(String.valueOf(day));

        //Tarih icin ay secin
        WebElement month =driver.findElement(By.xpath("//*[@id='month']"));
        select.selectByVisibleText(String.valueOf(month));
        //Tarih icin yil secin
        WebElement year =driver.findElement(By.xpath("//*[@id='year']"));
        select.selectByVisibleText(String.valueOf(year));

        //Cinsiyeti secin
        driver.findElement(By.xpath("//label[.='Kadın']")).click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin


    }
}
