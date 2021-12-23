package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralPage {


    //Locator Element
    @FindBy (xpath = "//input[@id='username']")
    private WebElement txtUsername;
    @FindBy (xpath = "//input[@id='password']")
    private WebElement txtPassword;
    @FindBy (xpath = "//*[@id=\"content\"]/form/fieldset/p/input")
    private WebElement btnLogin;
    @FindBy (xpath = "//p[@class='message error LoginForm']")
    private WebElement lbErrorMessage;






    //Login method return HomePage
    public HomePage login(String username, String password){
        //Submit login credentials
        PageFactory.initElements(Constant.WEBDRIVER,this);
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();

        //Land on Home Page
        return new HomePage();
    }


}
