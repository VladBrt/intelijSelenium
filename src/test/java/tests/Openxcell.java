package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Openxcell {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.openxcell.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        WebElement caseStudis = driver.findElement(By.linkText("Case Studies"));
        System.out.println(caseStudis.getAttribute("href"));
        System.out.println(caseStudis.getText());

        List<WebElement> d1 = driver.findElements(By.xpath("//body//a"));

        for(WebElement Link:d1){
            System.out.println(Link.getText());
        }
    }

}
