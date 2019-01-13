package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class OrangeLoginPage {
    WebDriver driver;
    public OrangeLoginPage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "txtUsername")
    public WebElement username ;

    @FindBy(id = "txtPassword")
    public WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement logInBtn;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;



    public void login(String userName, String passwordTxt){
        username.sendKeys(userName);
        password.sendKeys(passwordTxt);
        logInBtn.click();

    }


}
