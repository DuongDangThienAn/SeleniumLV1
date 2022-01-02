package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    //Locators
    private final By tbiDepartStation = By.xpath("//div[@id='content']//table//tr[@class='OddRow']/td[text()='Sài Gòn']/preceding-sibling::td[text()='Đà Nẵng']");
    private final By tbiArriveStation = By.xpath("//div[@id='content']//table//tr[@class='OddRow']/td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']");
    private final By lnkCheckPrice = By.xpath("//div[@id='content']//table//tr[@class='OddRow']/td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/../td/a[@href='TicketPricePage.cshtml?id1=1&id2=2']");

    //Elements
    protected WebElement getTbiDepartStation(){
        return Constant.WEBDRIVER.findElement(tbiDepartStation);
    }

    protected WebElement getTbiArriveStation(){
        return Constant.WEBDRIVER.findElement(tbiArriveStation);
    }

    protected WebElement getLnkCheckPrice(){
        return Constant.WEBDRIVER.findElement(lnkCheckPrice);
    }

    //Methods

    public String getDepartStation(){
        return this.getTbiDepartStation().getText();
    }

    public String getArriveStation(){
        return this.getTbiArriveStation().getText();
    }

    public void clickCheckPrice(){
        this.getLnkCheckPrice().click();
    }
}
