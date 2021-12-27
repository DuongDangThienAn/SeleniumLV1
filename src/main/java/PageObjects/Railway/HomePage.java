package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralPage {

    //Locator
    @FindBy (xpath = "//div[@id='content']/div/a[@href='/Account/Register.cshtml']")
    private WebElement lnkCreateAccount;
    //Elements

    //Methods

    //This is our methods that start our test cases
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public String getCreateAccountLinkText(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.lnkCreateAccount.getText();
    }
}
