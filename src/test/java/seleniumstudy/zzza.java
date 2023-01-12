package seleniumstudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class zzza extends TestBase {



    @Test
    public void test01(){
        //    1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //    2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).click();

        //    3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        String dosyaYolu = "C:\\Users\\Asus\\Downloads\\some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        //****************************************************************************************//
        //DAHA DINAMIK
        String farklıKısım=System.getProperty("user.home");
        String ortakKısım="\\Downloads\\some-file.txt";

        String dosyaYolu2=farklıKısım+ortakKısım;



        // String dosyaYolu="C:\\Users\\BURAK\\Downloads\\some-file.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));



    }




}
