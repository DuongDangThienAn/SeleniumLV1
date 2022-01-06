package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends GeneralPage {

    //Locator
    private final By lbRegisterErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
    private final By lbPasswordFieldErrorMsg = By.xpath("//div[@id='content']/form//ol/li[@class='password']/label[@class='validation-error']");
    private final By lbPIDFieldErrorMsg = By.xpath("//div[@id='content']/form//ol/li[@class='pid-number']/label[@class='validation-error']");
    private final By txtEmail = By.xpath("//ol/li[@class='email']/input[@id='email']");
    private final By txtPassword = By.xpath("//ol/li[@class='password']/input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//ol/li[@class='confirm-password']/input[@id='confirmPassword']");
    private final By txtPID = By.xpath("//ol/li[@class='pid-number']/input[@id='pid']");
    private final By btnRegister = By.xpath("//p[@class='form-actions']/input[@value='Register']");
    private final By lblRegisterSuccessfullyMsg = By.xpath("//div[@id='content']/p");

    //Element
    protected WebElement getLbRegisterErrorMsg() {
        return Constant.WEBDRIVER.findElement(lbRegisterErrorMsg);
    }

    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    protected WebElement getLblRegisterSuccessfullyMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccessfullyMsg);
    }

    protected WebElement getLbPasswordFieldErrorMsg() {
        return Constant.WEBDRIVER.findElement(lbPasswordFieldErrorMsg);
    }

    protected WebElement getLbPIDFieldErrorMsg() {
        return Constant.WEBDRIVER.findElement(lbPIDFieldErrorMsg);
    }

    //Methods
    public RegisterPage register(String email, String password, String confirm_pass, String PID) {

        PageFactory.initElements(Constant.WEBDRIVER, this);
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirm_pass);
        this.getTxtPID().sendKeys(PID);
        this.getBtnRegister().submit();

        return this;
    }

    public String getRegisterSuccessfullyMsg() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.getLblRegisterSuccessfullyMsg().getText();
    }

    public String getRegisterErrorMessage() {
        return this.getLbRegisterErrorMsg().getText();
    }

    public String getPasswordFieldErrorMsg() {
        return this.getLbPasswordFieldErrorMsg().getText();
    }

    public String getPIDFieldErrorMsg() {
        return this.getLbPIDFieldErrorMsg().getText();
    }
}
