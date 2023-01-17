package pdf.wait;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Soru02 extends TestBase {

@Test
    public void test01(){

    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()

    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın


    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    driver.findElement(By.xpath("//*[.='Enable']")).click();

    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

}

public void isEnabled(){



}

}
