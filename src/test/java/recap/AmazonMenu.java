package recap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;



public class AmazonMenu extends TestBase {
    @Test
    public void test1(){
        driver.get("http://www.amazon.com");
        Actions act = new Actions(driver);
        WebElement e1 = driver.findElement(By.id("icp-nav-flyout"));
        act.moveToElement(e1).perform();
}
}
