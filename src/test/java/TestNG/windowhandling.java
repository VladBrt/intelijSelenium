package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;


public class windowhandling {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        driver.get("http://the-internet.herokuapp.com/windows");
        String mainH = driver.getWindowHandle();
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("Elemental Selenium")).click();
        System.out.println(driver.getTitle());
        List<String> wHandels = new ArrayList<String>(driver.getWindowHandles());
        for(String s : wHandels) {
            if (!s.equals(mainH)) {
                driver.switchTo().window(s);
                break;
            }
        }
         // driver.switchTo().window(wHandels.get(1));
            System.out.println(driver.getTitle());
            driver.close();
            driver.switchTo().window(mainH);
            System.out.println(driver.getTitle());


    }

}
