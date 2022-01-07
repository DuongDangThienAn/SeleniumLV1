package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTicketPage extends GeneralPage {
    //Locators
    String btnDeleteTicket = "//div[@id='content']//table/tbody/tr/td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Operation']/preceding-sibling::th)+1]/input";

    private final By ddlDepartStationFilter = By.xpath("//div[@class='Filter']/table//tr/td/select[@name='FilterDpStation']");
    private final By ddlArriveStationFilter = By.xpath("//div[@class='Filter']/table//tr/td/select[@name='FilterArStation']");
    private final By txtDepartDateFilter = By.xpath("//div[@class='Filter']/table//tr/td/input[@name='FilterDpDate']");
    private final By btnApplyFilter = By.xpath("//div[@class='Filter']/div/input[@value='Apply Filter']");

    String tbiDepartStation = "//div[@class='DivTable']/table/tbody/tr/td[text()='%s']/preceding-sibling::td[text()='%s']";
    String tbiArriveStation = "//div[@class='DivTable']/table/tbody/tr/td[text()='%s']/following-sibling::td[text()='%s']";

    String[] actualDepartStations = {};
    String[] actualArriveStations = {};
    List<String> actualDepartStationList = new ArrayList<>(Arrays.asList(actualDepartStations));
    List<String> actualArriveStationList = new ArrayList<>(Arrays.asList(actualArriveStations));

    //Elements
    public WebElement getBtnDeleteTicket(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnDeleteTicket,depart,arrive)));
    }

    public WebElement getDdlDepartStationFilter(){
        return Constant.WEBDRIVER.findElement(ddlDepartStationFilter);
    }

    public WebElement getDdlArriveStationFilter(){
        return Constant.WEBDRIVER.findElement(ddlArriveStationFilter);
    }

    public WebElement getTxtDepartDateFilter(){
        return Constant.WEBDRIVER.findElement(txtDepartDateFilter);
    }

    public WebElement getBtnApplyFilter(){
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    public List<WebElement> getTbiArriveStation(String depart, String arrive){
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(tbiArriveStation, depart, arrive)));
    }

    public List<WebElement> getTbiDepartStation(String depart, String arrive){
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(tbiDepartStation, arrive, depart)));
    }

    //Methods
    public String[] getActualDepartStations(String depart, String arrive){
        for(int i = 0; i < getTbiDepartStation(depart, arrive).size(); i++){
            String actualDepartStation = getTbiDepartStation(depart,arrive).get(i).getText();
            actualDepartStationList.add(actualDepartStation);
        }
        actualDepartStations = actualDepartStationList.toArray(new String[actualDepartStationList.size()]);
        return actualDepartStations;
    }

    public String[] getActualArriveStations(String depart, String arrive){
        for(int i = 0; i < getTbiArriveStation(depart, arrive).size(); i++){
            String actualArriveStation = getTbiArriveStation(depart,arrive).get(i).getText();
            actualArriveStationList.add(actualArriveStation);
        }
        actualArriveStations = actualArriveStationList.toArray(new String[actualArriveStationList.size()]);
        return actualArriveStations;
    }

    public void deleteTicket(String depart, String arrive) {
        Utilities.scrollIntoView(getBtnDeleteTicket(depart,arrive));
        this.getBtnDeleteTicket(depart,arrive).click();
    }

    public void selectDepartStationFilter(String departOption){
        Select select = new Select(getDdlDepartStationFilter());
        select.selectByVisibleText(departOption);
    }

    public void selectArriveStationFilter(String arriveOption){
        Select select = new Select(getDdlArriveStationFilter());
        select.selectByVisibleText(arriveOption);
    }

    public void inputDepartDateFilter(String departDate){
        this.getTxtDepartDateFilter().sendKeys(departDate);
    }

    public void clickApplyFilter(){
        this.getBtnApplyFilter().click();
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
