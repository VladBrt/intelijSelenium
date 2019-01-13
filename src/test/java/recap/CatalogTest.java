package recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;



public class CatalogTest extends TestBase {
    @Test
    public void click(){
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        Actions act = new Actions(driver);

        act.doubleClick(driver.findElement(By.id("puff_header"))).perform();
    }
    @Test
    public void dragAndSrop() throws InterruptedException{
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
       WebElement target = driver.findElement(By.id("droptarget"));
       WebElement point = driver.findElement(By.id("draggable"));
       Actions act = new Actions(driver);
      // act.dragAndDrop(point,target).perform();
       act.clickAndHold(point).perform();
       act.moveToElement(target).perform();
       Thread.sleep(5000);
       act.release().perform();
    }

    @Test
    public void path(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dw = driver.findElement(By.id("file-upload"));
        dw.sendKeys("C:\\Users\\Volodymyr\\Desktop\\CybertekNotes\\cybertek-logo.png");
        driver.findElement(By.id("file-submit")).click();
    }
}
