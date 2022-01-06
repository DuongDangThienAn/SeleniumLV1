package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    //Locators
    String tbiDepartStation = "//div[@id='content']//table//tr[@class='OddRow']/td[text()='%s']/preceding-sibling::td[text()='%s']";
    String tbiArriveStation = "//div[@id='content']//table//tr[@class='OddRow']/td[text()='%s']/following-sibling::td[text()='%s']";
    String lnkCheckPrice = "//div[@id='content']//table//tr[@class='OddRow']/td[text()='%s']/following-sibling::td[text()='%s']/../td/a[@href='TicketPricePage.cshtml?id1=1&id2=2']";

    //Elements
    public WebElement getTbiDepartStation(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tbiDepartStation, arrive, depart)));
    }

    public WebElement getTbiArriveStation(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tbiArriveStation, depart, arrive)));
    }

    public WebElement getLnkCheckPrice(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, depart, arrive)));
    }

    //Methods

    public String getDepartStation(String depart, String arrive) {
        return this.getTbiDepartStation(depart, arrive).getText();
    }

    public String getArriveStation(String depart, String arrive) {
        return this.getTbiArriveStation(depart, arrive).getText();
    }

    public void clickCheckPrice(String depart, String arrive) {
        this.getLnkCheckPrice(depart, arrive).click();
    }
}
