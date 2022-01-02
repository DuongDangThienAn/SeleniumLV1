package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketPricePage extends GeneralPage{
    //Locators
    private final By tbiSeatTypes = By.xpath("//div[@id='content']//div[@class='DivTable']/table/tbody//th[normalize-space()='Seat type']/following-sibling::td");
    private final By tbiTicketPrices = By.xpath("//div[@id='content']//div[@class='DivTable']/table/tbody//th[normalize-space()='Price (VND)']/following-sibling::td");
    private final By lblTableTitle = By.xpath("//div[@id='content']//div[@class='DivTable']/table/tbody/tr[@class='TableSmallHeader']/th");

    //Elements
    protected WebElement getLblTableTitle(){
        return Constant.WEBDRIVER.findElement(lblTableTitle);
    }

    protected List<WebElement> getTbiSeatTypes(){
        return Constant.WEBDRIVER.findElements(tbiSeatTypes);
    }

    protected List<WebElement> getTbiTicketPrices(){
        return Constant.WEBDRIVER.findElements(tbiTicketPrices);
    }

    //Methods
    public String getTableTitle(){
        return this.getLblTableTitle().getText();
    }

    public String[] actualSeatTypes = {};
    List<String> actualSeatTypeList = new ArrayList<>(Arrays.asList(actualSeatTypes));
    public String[] getSeatTypeList(){
        for(int i = 0; i < getTbiSeatTypes().size(); i++){
            String actualSeatType = getTbiSeatTypes().get(i).getText();
            actualSeatTypeList.add(actualSeatType);
        }
        actualSeatTypes = actualSeatTypeList.toArray(new String[actualSeatTypeList.size()]);
        return actualSeatTypes;
    }

    public String[] actualTicketPrices = {};
    List<String> actualTicketPriceList = new ArrayList<>(Arrays.asList(actualTicketPrices));
    public String[] getTicketPriceList(){
        for(int i = 0; i < getTbiTicketPrices().size();i++){
            String actualTicketPrice = getTbiTicketPrices().get(i).getText();
            actualTicketPriceList.add(actualTicketPrice);
        }
        actualTicketPrices = actualTicketPriceList.toArray(new String[actualSeatTypeList.size()]);
        return actualTicketPrices;
    }



}
