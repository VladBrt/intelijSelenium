package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.OrangeLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangeAdmin extends TestBase {

    @Ignore
    @Test
    public void logIn(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");
        driver.findElement(By.id("btnLogin"));
        WebElement admin = driver.findElement(By.id("welcome"));
        Assert.assertTrue(admin.isDisplayed());
    }
    @Test
    public void loginVerification(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.login("Admin","admin123");

        OrangeHomePage ohp = new OrangeHomePage(driver);
        Assert.assertTrue(ohp.welcome.isDisplayed());

        ohp.welcome.click();
        ohp.about.click();
        Assert.assertTrue(ohp.companyInfo.getText().contains("OrangeHRM"));
    }

    @Test
    public void TC1() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.login("Admin", "admin123");
        Actions action = new Actions(driver);
        OrangeHomePage ohp = new OrangeHomePage(driver);
        action.moveToElement(ohp.performance).perform();
        action.moveToElement(ohp.configure).perform();
        ohp.KPIs.click();
        Select jobTitle = new Select(ohp.jobTitle);
        List<WebElement> jobTitleList = jobTitle.getOptions();
        boolean found = false;
        for (WebElement w : jobTitleList) {
            if (w.getText().equals("CEO")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }



}
