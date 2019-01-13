package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Iframes {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws  InterruptedException{
        driver.get("http://automationpractice.com");
        Thread.sleep(2000);
        WebElement iframe = driver.findElement(By.xpath("//div[@class='col-xs-4']//iframe"));
        driver.switchTo().frame(iframe);
        WebElement elem = driver.findElement(By.xpath("//span[@id='u_0_6']"));
        System.out.println(elem.getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());



    }
}
