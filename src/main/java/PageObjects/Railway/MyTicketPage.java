package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends GeneralPage {
    //Locators
    String btnDeleteTicket = "//div[@id='content']//table/tbody/tr/td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Operation']/preceding-sibling::th)+1]/input";

    //Elements
    public WebElement getBtnDeleteTicket(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnDeleteTicket,depart,arrive)));
    }

    //Methods
    public void deleteTicket(String depart, String arrive) {
        Utilities.scrollIntoView(getBtnDeleteTicket(depart,arrive));
        this.getBtnDeleteTicket(depart,arrive).click();
    }

    public boolean isDeleteButtonDisappear(String depart,String arrive) {
        try {
            getBtnDeleteTicket(depart, arrive);
            return false;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return true;
        }
    }
}
