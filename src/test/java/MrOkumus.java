import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class MrOkumus extends TestBase {

    @Test
    public void test01(){
        mesajYagdir();
    }
    public void mesajYagdir() {
        //rehberinizdeki kayitli isim
        String isim = "turgay";
        String gondermekIstediginizMesaj = "hoooouuup";
        String gondermekIstediginizMesaj2 = "hayydaaaaa :)";
        int kacTaneMesajAtmakIstiyorsunuz = 100;


        driver.get("https://web.whatsapp.com/");
        driver.findElement(By.xpath("//span[@data-testid='chat']")).click();
        driver.
                findElement(By.xpath("//div[@class='_1UWac _3hKpJ focused']//div[@title='Arama metni giriş alanı']")).
                sendKeys(isim+ Keys.TAB + Keys.ENTER);


        for (int i = 0; i < kacTaneMesajAtmakIstiyorsunuz; i++) {
            driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys(gondermekIstediginizMesaj + Keys.ENTER);

        }
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("tamam tamam bu mesaj sondu hadi iyi geceler :)" + Keys.ENTER);
        waitFor(8);
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("Saka yaptım :)))) devammmm hoppplaa " + Keys.ENTER);
        for (int i = 0; i < kacTaneMesajAtmakIstiyorsunuz; i++) {
            driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys(gondermekIstediginizMesaj2 + Keys.ENTER);
        }
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("tamam bro bu sondu  hadi iyi geceler ."+Keys.ENTER );
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("Saka yahu devammmm hoppplaa " + Keys.ENTER);





        //EXCELLE ILGILI REUSABLE METHOD YAPMIS

        //  System.out.println(getData(path, "Sheet1", 2, 0));
        //
        //
        //}
        //
        //
        //public Cell getData(String path, String sheet, int row, int column) throws Exception {
        //    Cell cell = WorkbookFactory.
        //            create(new FileInputStream(path)).
        //            getSheet(sheet).
        //            getRow(row).
        //            getCell(column);
        //    return cell;
        //}



        //EXCELLE ILGILI BIR SORU ATMIS
        //Arkadaslar iyi calismalar. Ufak bir Soru var bakmak isterseniz.
        //2. Excelde bulunan butun mail ve sifre ile sisteme giris yapildigini dogrulayan dinamik bir method olusturun.
        //3.  Exceldeki tablodaki isimler icin de  "Turuncu" olup olmadigini test edin.
        //4. Sistemde olan kisilerin ad ve soyadlarini yazdiran diamik bir method  olusturun.
        //5.  ? olan hucreye "Age" olarak ekleyin, ve asagidaki yaslari girin.
        //    Yesil=27
        //    Mavi=25
        //    Turuncu=35
    }
}
