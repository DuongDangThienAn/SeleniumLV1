package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralPage {

    //Locator
    private final By lnkCreateAccount = By.xpath("//div[@id='content']/div/a[@href='/Account/Register.cshtml']");

    //Elements
    protected WebElement getLnkCreateAccount(){
        return Constant.WEBDRIVER.findElement(lnkCreateAccount);
    }

    //This is our methods that start our test cases
    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public String getCreateAccountLinkText(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.getLnkCreateAccount().getText();
    }
}
