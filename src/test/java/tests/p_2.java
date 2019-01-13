package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class p_2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();
        driver2.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        WebElement userName2 = driver2.findElement(By.name("ctl00$MainContent$username"));
        userName2.sendKeys("Tester");
        WebElement login = driver2.findElement(By.name("ctl00$MainContent$login_button"));
        login.click();
        WebElement error = driver2.findElement(By.id("ctl00_MainContent_status"));
        if(error.getText().equals("Invalid Login or Password.")){
            System.out.println("Passed");
        }else{
            System.out.println(false);
        }
    }
}
