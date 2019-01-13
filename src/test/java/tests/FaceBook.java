package tests;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;
import java.util.Map;

public class FaceBook {
        public static void main(String[] args) throws InterruptedException {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_settings_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Volodymyr\\Documents\\Selenium dependencies\\Drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://www.facebook.com");
            driver.manage().window().maximize();
            WebElement name = driver.findElement(By.id("email"));
            WebElement password = driver.findElement(By.id("pass"));
            name.sendKeys("bartez007@i.ua");
            password.sendKeys("06061991aA");
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            WebElement search = driver.findElement(By.name("q"));
            search.sendKeys("Sofiia Rudenka");
            Thread.sleep(5000);
            WebElement click = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _4w98 _4jy3 _517h _51sy _4w97']"));
            Thread.sleep(2000);
            click.click();
            Thread.sleep(2000);

            WebElement selection = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _55pi _2agf _4o_4 _p _4jy3 _517h _51sy']"));
            Thread.sleep(2000);
            selection.click();
            Thread.sleep(2000);
            WebElement message = driver.findElement(By.xpath("//span[text()='Send message']"));
            message.click();
            Thread.sleep(3000);
            WebElement type = driver.findElement(By.name("message_body"));
            type.sendKeys("Hello World!");
            driver.findElement(By.xpath("//button[@class='_42ft _4jy0 layerConfirm _2ok uiOverlayButton _4jy4 _4jy1 selected _51sy']")).click();

        }
    }

