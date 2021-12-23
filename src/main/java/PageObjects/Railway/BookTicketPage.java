package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookTicketPage extends GeneralPage{

    private final By txaBookTicketTitle = By.xpath("//div[@id='content']/h1");

    protected WebElement getTxaBookTicketTitle(){
        return Constant.WEBDRIVER.findElement(txaBookTicketTitle);
    }

    //Methods
    public String getBookTicketTitle(){
        return this.getTxaBookTicketTitle().getText();
    }

}
