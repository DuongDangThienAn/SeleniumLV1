package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Getter methods for retrieving WebElements
    protected  WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected  WebElement getLbWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lbWelcomeMessage);
    }
    //Page Methods

    public String getWelcomeMessage(){
        return this.getLbWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
}
