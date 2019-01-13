package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {
    WebDriver driver;
    public OrangeHomePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "welcome")
    public WebElement welcome;

    @FindBy(id = "aboutDisplayLink")
    public WebElement about;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logOut;

    @FindBy(xpath = "//p[.='Company Name: OrangeHRM (Pvt) Ltd']")
    public WebElement companyInfo;
    @FindBy(id = "menu__Performance")
    public WebElement performance;

    @FindBy (id = "menu_performance_Configure")
    public WebElement configure;

    @FindBy(id = "menu_performance_searchKpi")
    public WebElement KPIs;

    @FindBy(xpath = "//select[@class=‘formSelect’]")
            public WebElement jobTitle;

}
