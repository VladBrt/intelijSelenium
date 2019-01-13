package TestNG;

import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Orange {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();


    }
    @BeforeMethod
    public  void beforeMethod(){
        driver.manage().window().maximize();
        this.driver.get("https://opensource-demo.orangehrmlive.com/");

    }
    @AfterClass
    public void cleaning(){
        driver.quit();
    }

    @AfterMethod
    public void testClranUp(){
        driver.close();
    }

    @Test
    public void orangeTitleVerification(){
        assertEquals(driver.getTitle(), "OrangeHRM", "OrangeHRM title verification");
    }

    @Test
    public void  orangeLogInVerification(){
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();


    }
}

