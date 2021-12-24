package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends GeneralPage{
    //Locator
    @FindBy (xpath = "//div[@id='content']/h1[text()='Contact Information']")
    private WebElement txaContactPageTitle;



    //Methods
    public String getContactPageTitle(){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        return this.txaContactPageTitle.getText();
    }



}
