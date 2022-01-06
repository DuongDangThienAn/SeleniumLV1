package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralPage {

    //Locator
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//*[@id='content']/form/fieldset/p/input");
    private final By lbErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By lbEmailErrorMessage = By.xpath("//li[@class='username']/./label[@class='validation-error']");
    private final By lbPasswordErrorMessage = By.xpath("//div[@id='content']/form/fieldset/ol/li[@class='password']/label[@class='validation-error']");

    //Elements
    protected WebElement getLbEmailErrorMessage() {
        return Constant.WEBDRIVER.findElement(lbEmailErrorMessage);
    }

    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    protected WebElement getLbErrorMessage() {
        return Constant.WEBDRIVER.findElement(lbErrorMessage);
    }

    protected WebElement getLbPasswordErrorMessage() {
        return Constant.WEBDRIVER.findElement(lbPasswordErrorMessage);
    }

    //Methods
    public String getErrorMessage() {
        try{
            getLbErrorMessage();
            return this.getLbErrorMessage().getText();
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return "";
        }
    }

    public String getEmailErrorMessage() {
        return this.getLbEmailErrorMessage().getText();
    }

    public String getPasswordErrorMessage() {
        return this.getLbPasswordErrorMessage().getText();
    }

    public void login(String username, String password) {
        //Submit login credentials
        PageFactory.initElements(Constant.WEBDRIVER, this);
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public void loginMultipleTimes(String username, String password, int time) {

        PageFactory.initElements(Constant.WEBDRIVER, this);
        for (int i = 0; i < time; i++) {
            getTxtUsername().sendKeys(username);
            getTxtPassword().sendKeys(password);
            getBtnLogin().click();
        }
    }


}
