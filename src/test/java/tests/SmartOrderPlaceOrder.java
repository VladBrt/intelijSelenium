package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SmartOrderPlaceOrder extends p_3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().window().maximize();
        logInToSmartBear(driver);
        WebElement viewAllOrder = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrder.click();
        WebElement orderDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));
        if(orderDate.equals("01/05/2010")){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        verifyOrder(driver, "Susan McLaren");
        printAllNames(driver);

        
    }

    public static void verifyOrder(WebDriver driver, String orderName){
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for(WebElement name:names){
            if(name.getText().equals(orderName)){
                System.out.println("Name exist in Order");
                return;
            }
        }
        System.out.println("Name does not exist in Order");
    }

    public static void printAllNames(WebDriver driver){
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i).getText());
        }
    }

}