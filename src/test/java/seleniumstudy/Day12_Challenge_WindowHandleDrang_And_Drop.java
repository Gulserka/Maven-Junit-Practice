package seleniumstudy;

import org.bouncycastle.util.io.TeeInputStream;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day12_Challenge_WindowHandleDrang_And_Drop extends TestBase{

    @Test
    public void test01(){

           /*
    #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    #Fill in capitals by country
    */
    /*
    #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
     #Ülkeye göre başkentleri doldurun
    */
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        for (int i=1 ; i <8 ; i++) {
            WebElement baskent=driver.findElement(By.id("box"+i));
            WebElement ulke=driver.findElement(By.id("box"+(100+i)));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(baskent,ulke).perform();
        }





    }




}
