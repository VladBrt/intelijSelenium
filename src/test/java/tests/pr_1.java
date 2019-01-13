package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import javax.xml.ws.WebEndpoint;

public class pr_1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        if (driver.getTitle().equals("Web Orders Login")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
        /*login.click();
        if (driver.getTitle().equals("Web Order")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (driver.getCurrentUrl().equals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }*/
        negativeLogin(driver, "Tester","");
        negativeLogin(driver, "","12432");
        negativeLogin(driver, "","text");
        negativeLogin(driver, "","test");
        negativeLogin(driver, "Tester","10");

    }
        public static void negativeLogin(WebDriver driver ,String userNname, String password){

            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
            WebElement userName2 = driver.findElement(By.name("ctl00$MainContent$username"));
            userName2.sendKeys("Tester");
            WebElement login2 = driver.findElement(By.name("ctl00$MainContent$login_button"));
            login2.click();
            WebElement error = driver.findElement(By.id("ctl00_MainContent_status"));
            if(error.getText().equals("Invalid Login or Password.")){
                System.out.println("Passed");
            }else{
                System.out.println(false);
            }

    }

}
