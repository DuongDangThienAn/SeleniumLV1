package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage{

    //Locator
    private final By lblBookTicketTitle = By.xpath("//div[@id='content']/h1");
    private final By ddlDepartDate = By.xpath("//div[@id='content']//form//ol//li/select[@name='Date']");
    private final By ddlDepartFrom = By.xpath("//div[@id='content']//form//ol//li/select[@name='DepartStation']");
    private final By ddlArriveAt = By.xpath("//div[@id='content']//form//ol//li//select[@name='ArriveStation']");
    private final By ddlSeatType = By.xpath("//div[@id='content']//form//ol//li/select[@name='SeatType']");
    private final By ddlTicketAmount = By.xpath("//div[@id='content']//form//ol//li/select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//div[@id='content']//form//input[@type='submit']");
    private final By lblTicketBookedSuccessfully = By.xpath("//div[@id='content']/h1");

    private final By tbiDepartStation = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1]");
    private final By tbiArriveStation = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th) + 1]");
    private final By tbiSeatType = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Seat Type']/preceding-sibling::th) + 1]");
    private final By tbiDepartDate = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Depart Date']/preceding-sibling::th) + 1]");
    private final By tbiBookDate = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Book Date']/preceding-sibling::th) + 1]");
    private final By tbiExpiredDate = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Expired Date']/preceding-sibling::th) + 1]");
    private final By tbiAmount = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Amount']/preceding-sibling::th) + 1]");

    //Elements
    protected WebElement getLblBookTicketTitle(){
        return Constant.WEBDRIVER.findElement(lblBookTicketTitle);
    }

    protected WebElement getLblTicketBookSuccessfully(){
        return Constant.WEBDRIVER.findElement(lblTicketBookedSuccessfully);
    }

    protected WebElement getBtnBookTicket(){
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getDdlDepartDate(){
        return Constant.WEBDRIVER.findElement(ddlDepartDate);
    }

    protected WebElement getDdlDepartFrom(){
        return Constant.WEBDRIVER.findElement(ddlDepartFrom);
    }

    protected WebElement getDdlArriveAt(){
        return Constant.WEBDRIVER.findElement(ddlArriveAt);
    }

    protected WebElement getDdlSeatType(){
        return Constant.WEBDRIVER.findElement(ddlSeatType);
    }

    protected WebElement getDdlTicketAmount(){
        return Constant.WEBDRIVER.findElement(ddlTicketAmount);
    }

    protected WebElement getTbiDepartStation(){
        return Constant.WEBDRIVER.findElement(tbiDepartStation);
    }

    protected WebElement getTbiArriveStation(){
        return Constant.WEBDRIVER.findElement(tbiArriveStation);
    }

    protected WebElement getTbiSeatType(){
        return Constant.WEBDRIVER.findElement(tbiSeatType);
    }

    protected WebElement getTbiDepartDate(){
        return Constant.WEBDRIVER.findElement(tbiDepartDate);
    }

    protected WebElement getTbiBookDate(){
        return Constant.WEBDRIVER.findElement(tbiBookDate);
    }

    protected WebElement getTbiExpiredDate(){
        return Constant.WEBDRIVER.findElement(tbiExpiredDate);
    }

    protected WebElement getTbiAmount(){
        return Constant.WEBDRIVER.findElement(tbiAmount);
    }

    //Methods
    public String getBookTicketTitle(){
        return this.getLblBookTicketTitle().getText();
    }

    public String getTicketBookedSuccessfullyTitle(){
        return this.getLblTicketBookSuccessfully().getText();
    }

    public void selectDepartDate(String dateOption){
        Select select = new Select(getDdlDepartDate());
        select.selectByVisibleText(dateOption);
    }

    public void selectDepartFrom(String departFromOption){
        Select select = new Select(getDdlDepartFrom());
        select.selectByVisibleText(departFromOption);
    }

    public void selectArriveAt(String arriveAtOption){
        Select select = new Select(getDdlArriveAt());
        select.selectByVisibleText(arriveAtOption);
    }

    public void selectSeatType(String seatTypeOption){
        Select select = new Select(getDdlSeatType());
        select.selectByVisibleText(seatTypeOption);
    }

    public void selectTicketAmount(String ticketAmountOption){
        Select select = new Select(getDdlTicketAmount());
        select.selectByVisibleText(ticketAmountOption);
    }

    public String getDepartStation(){
        return this.getTbiDepartStation().getText();
    }

    public String getArriveStation(){
        return this.getTbiArriveStation().getText();
    }

    public String getSeatType(){
        return this.getTbiSeatType().getText();
    }

    public String getDepartDate(){
        return this.getTbiDepartDate().getText();
    }

    public String getBookTicketDate(){
        return this.getTbiBookDate().getText();
    }

    public String getExpiredDate(){
        return this.getTbiExpiredDate().getText();
    }

    public String getBookedTicketAmount(){
        return this.getTbiAmount().getText();
    }

    public void bookTicketSubmit(){
        this.getBtnBookTicket().submit();
    }

}
