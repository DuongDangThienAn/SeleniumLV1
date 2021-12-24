package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralPage {
    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");

    private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lbEmailErrorMessage = By.xpath("//li[@class=\"username\"]/./label[@class=\"validation-error\"]");
    private final By lbLoginErrorMessage = By.xpath("//p[@class='message error LoginForm']");



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

    protected WebElement getLbEmailErrorMessage(){
        return Constant.WEBDRIVER.findElement(lbEmailErrorMessage);
    }

    protected WebElement getLbLoginErrorMessage(){
        return Constant.WEBDRIVER.findElement(lbLoginErrorMessage);
    }


    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabContact(){
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    //Page Methods
    public String getWelcomeMessage(){
        return this.getLbWelcomeMessage().getText();
    }

    public String getEmailErrorMessage(){
        return this.getLbEmailErrorMessage().getText();
    }

    public String getLoginErrorMessage(){
        return this.getLbLoginErrorMessage().getText();
    }

    public BookTicketPage gotoBookTicketPage(){
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public ContactPage gotoContactPage(){
        this.getTabContact().click();
        return new ContactPage();
    }

    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public HomePage getLogOut(){
        this.getTabLogout().click();
        return new HomePage();
    }
}
