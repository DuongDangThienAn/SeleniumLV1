package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends GeneralPage {
    //Locator
    private final By lblContactPageTitle = By.xpath("//div[@id='content']/h1[text()='Contact Information']");

    //Element
    protected WebElement getLblContactPageTitle() {
        return Constant.WEBDRIVER.findElement(lblContactPageTitle);
    }


    //Methods
    public String getContactPageTitle() {
        PageFactory.initElements(Constant.WEBDRIVER, this);
        return this.getLblContactPageTitle().getText();
    }


}
