package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locator
    private final By lbErrorMessage = By.xpath("//div[@id='content']/form//p[@class='message error']");
    private final By lbConfirmPasswordErrorMsg = By.xpath("//div[@id='content']/form//ol/li[@class='confirm-password']/label[@class='validation-error']");

    private final By txtCurrentPassword = By.xpath("//div[@id='content']/form[@id='ChangePW']//ol//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//div[@id='content']/form[@id='ChangePW']//ol//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//div[@id='content']/form[@id='ChangePW']//ol//input[@id='confirmPassword']");
    private final By btnChangePassword = By.xpath("//div[@id='content']//p[@class='form-actions']/input[@value='Change Password']");

    //Element
    protected WebElement getLbChangePasswordErrorMessage() {
        return Constant.WEBDRIVER.findElement(lbErrorMessage);
    }

    protected WebElement getLbConfirmPasswordErrorMsg() {
        return Constant.WEBDRIVER.findElement(lbConfirmPasswordErrorMsg);
    }

    protected WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    protected WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    //Methods
    public String getChangePasswordErrorMessage() {
        return this.getLbChangePasswordErrorMessage().getText();
    }

    public String getConfirmPasswordErrorMsg() {
        return this.getLbConfirmPasswordErrorMsg().getText();
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().submit();
    }
}
