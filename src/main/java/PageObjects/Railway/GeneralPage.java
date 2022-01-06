package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Getter methods for retrieving WebElements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLbWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lbWelcomeMessage);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    //Page Methods
    public String getWelcomeMessage() {
        return this.getLbWelcomeMessage().getText();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void getLogOut() {
        this.getTabLogout().click();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void gotoTimeTablePage() {
        this.getTabTimeTable().click();
    }

    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public String getLoginButtonText() {
        return this.getTabLogin().getText();
    }

}
