package tests;

import com.github.javafaker.Faker;
import com.sun.org.apache.bcel.internal.generic.Visitor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class p_3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().window().maximize();
        logInToSmartBear(driver);
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println(links.size());
        for(int i = 0; i < links.size(); i ++){
            System.out.println(links.get(i).getText());
        }
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select pDropDown = new Select(product);
        pDropDown.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
        Faker faker = new Faker();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().cityName());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.address().zipCode().replace("-",""));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.finance().creditCard().replace("-",""));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/25");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        WebElement message = driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String text = message.getText();
        if(text.equals("New order has been successfully added.")){
            System.out.println("Order verification Passed");
        }else{
            System.out.println("Order verification Failed");
        }
        System.out.println(message.isDisplayed());


    }




    public static void logInToSmartBear(WebDriver driver){
        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
        login.click();
    }
}

