package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class JSAlert {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Ignore
    @Test
    public void warningAlert() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Thread.sleep(1000);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

    }
    @Ignore
    @Test
    public void jsConfirm() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.dismiss();
    }

    @Test
    public void jsPromp() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.getText();
        Thread.sleep(2000);
        firstAlert.sendKeys("Hello World");
        firstAlert.accept();
    }
}