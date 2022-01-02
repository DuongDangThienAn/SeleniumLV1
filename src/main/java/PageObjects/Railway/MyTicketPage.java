package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{
    //Locators
    private final By btnDeleteTicket = By.xpath("//div[@id='content']//table/tbody/tr[@class='OddRow']/td[count(//th[text()='Operation']/preceding-sibling::th)+1]/input");

    //Elements
    public WebElement getBtnDeleteTicket(){
        return Constant.WEBDRIVER.findElement(btnDeleteTicket);
    }

    //Methods
    public void deleteTicket(){
        Utilities.scrollIntoView();
        this.getBtnDeleteTicket().click();
    }

    public boolean isDeleteButtonDisappear(){
        try{
            getBtnDeleteTicket();
            return false;
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return true;
        }
    }
}
