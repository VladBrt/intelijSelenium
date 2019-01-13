package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Amazon {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        WebElement dropDown = driver.findElement(By.xpath("//span[@class='nav-search-label']"));
        System.out.println(dropDown.getText());
        if(dropDown.getText().equals("All Departments")){
            System.out.println("Default Value Passed");
        }else{
            System.out.println("Default value Failed");
        }

        List<WebElement> options = driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
        if(options.size() == 51){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        for(int i = 0; i < options.size(); i++ ){
            if(options.get(i).getText().length() > 0){
                continue;
            }else{
                System.out.println("Find empty DropDown:" + i);
            }
        }
       // verifyDepartmentDropDown(driver, "Courses");

    }

    public static void verifyDepartmentDropDown(WebDriver driver, String option){
        WebElement dropDown = driver.findElement(By.xpath("//span[@class='nav-search-label']"));
        WebElement searchBox = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchBox);
        select.selectByVisibleText(option);

        if(dropDown.getText().equals("Courses")){
            System.out.println("Passed Courses Selection");
        }else{
            System.out.println("Failed Courses Selection");
        }
    }
}
