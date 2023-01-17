package pdf.fileexist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Soru01 extends TestBase {

    @Test
    public void test01(){

        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. text.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='text.txt']")).click();

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\text.txt";
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);



    }











}
