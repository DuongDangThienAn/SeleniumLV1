package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends GeneralPage{

    @FindBy (xpath = "//ol/li[@class='email']/input[@id='email']")
    private WebElement txtEmail;

    @FindBy (xpath = "//ol/li[@class='password']/input[@id='password']")
    private WebElement txtPassword;

    @FindBy (xpath = "//ol/li[@class='confirm-password']/input[@id='confirmPassword']")
    private WebElement txtConfirmPassword;

    @FindBy (xpath = "//ol/li[@class='pid-number']/input[@id='pid']")
    private WebElement txtPID;

    @FindBy (xpath = "//p[@class=\"form-actions\"]/input[@value='Register']")
    private WebElement btnRegister;

    @FindBy (xpath = "//div[@id='content']/p")
    private WebElement txaRegisterSuccessfullyMsg;

    //Locator
    private final By lbRegisterErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");

    //Element
    protected WebElement getLbRegisterErrorMsg(){
        return Constant.WEBDRIVER.findElement(lbRegisterErrorMsg);
    }

    //Methods
    public RegisterPage register(String email, String password, String confirm_pass, String PID){

        PageFactory.initElements(Constant.WEBDRIVER, this);
        this.txtEmail.sendKeys(email);
        this.txtPassword.sendKeys(password);
        this.txtConfirmPassword.sendKeys(confirm_pass);
        this.txtPID.sendKeys(PID);
        this.btnRegister.submit();

        return this;
    }

    public String getRegisterSuccessfullyMsg(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.txaRegisterSuccessfullyMsg.getText();
    }

    public String getRegisterErrorMessage(){
        return this.getLbRegisterErrorMsg().getText();
    }
}
