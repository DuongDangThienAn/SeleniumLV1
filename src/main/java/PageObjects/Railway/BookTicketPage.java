package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BookTicketPage extends GeneralPage {

    //Locator
    private final By lblBookTicketTitle = By.xpath("//div[@id='content']/h1");
    private final By ddlDepartDate = By.xpath("//div[@id='content']//form//ol//li/select[@name='Date']");
    private final By ddlDepartFrom = By.xpath("//div[@id='content']//form//ol//li/select[@name='DepartStation']");
    private final By ddlArriveAt = By.xpath("//div[@id='content']//form//ol//li//select[@name='ArriveStation']");
    private final By ddlSeatType = By.xpath("//div[@id='content']//form//ol//li/select[@name='SeatType']");
    private final By ddlTicketAmount = By.xpath("//div[@id='content']//form//ol//li/select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//div[@id='content']//form//input[@type='submit']");
    private final By lblTicketBookedSuccessfully = By.xpath("//div[@id='content']/h1");
    private final By lblBookTicketErrorMsg = By.xpath("//div[@id='content']/div/p[@class='message error']");
    private final By lblTicketAmountErrorMsg = By.xpath("//div[@id='content']/div/form//ol/li/label[@class='validation-error']");
    private final By optSelectedDepartFromOption = By.xpath("//div[@id='content']//form//ol//li/select[@name='DepartStation']/option[@selected='selected']");
    private final By optSelectedArriveAtFromOption = By.xpath("//div[@id='content']//form//ol//li/span/select[@name='ArriveStation']/option[@selected='selected']");

    private final By tbiDepartStation = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1]");
    private final By tbiArriveStation = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Arrive Station']/preceding-sibling::th) + 1]");
    private final By tbiSeatType = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Seat Type']/preceding-sibling::th) + 1]");
    private final By tbiDepartDate = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Depart Date']/preceding-sibling::th) + 1]");
    private final By tbiBookDate = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Book Date']/preceding-sibling::th) + 1]");
    private final By tbiExpiredDate = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Expired Date']/preceding-sibling::th) + 1]");
    private final By tbiAmount = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Amount']/preceding-sibling::th) + 1]");
    private final By tbiTicketPrice = By.xpath("//div[@class='DivTable']/table//tr[@class='OddRow']/td[count(//th[text()='Total Price']/preceding-sibling::th) + 1]");

    //Elements
    protected WebElement getLblBookTicketTitle() {
        return Constant.WEBDRIVER.findElement(lblBookTicketTitle);
    }

    protected WebElement getLblTicketBookSuccessfully() {
        return Constant.WEBDRIVER.findElement(lblTicketBookedSuccessfully);
    }

    protected WebElement getLblBookTicketErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblBookTicketErrorMsg);
    }

    protected WebElement getLblTicketAmountErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblTicketAmountErrorMsg);
    }

    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getDdlDepartDate() {
        return Constant.WEBDRIVER.findElement(ddlDepartDate);
    }

    protected WebElement getDdlDepartFrom() {
        return Constant.WEBDRIVER.findElement(ddlDepartFrom);
    }

    protected WebElement getDdlArriveAt() {
        return Constant.WEBDRIVER.findElement(ddlArriveAt);
    }

    protected WebElement getDdlSeatType() {
        return Constant.WEBDRIVER.findElement(ddlSeatType);
    }

    protected WebElement getDdlTicketAmount() {
        return Constant.WEBDRIVER.findElement(ddlTicketAmount);
    }

    protected WebElement getOptSelectedDepartFromOption(){
        return Constant.WEBDRIVER.findElement(optSelectedDepartFromOption);
    }

    protected WebElement getOptSelectedArriveAtOption(){
        return Constant.WEBDRIVER.findElement(optSelectedArriveAtFromOption);
    }

    protected WebElement getTbiDepartStation() {
        return Constant.WEBDRIVER.findElement(tbiDepartStation);
    }

    protected WebElement getTbiArriveStation() {
        return Constant.WEBDRIVER.findElement(tbiArriveStation);
    }

    protected WebElement getTbiSeatType() {
        return Constant.WEBDRIVER.findElement(tbiSeatType);
    }

    protected WebElement getTbiDepartDate() {
        return Constant.WEBDRIVER.findElement(tbiDepartDate);
    }

    protected WebElement getTbiBookDate() {
        return Constant.WEBDRIVER.findElement(tbiBookDate);
    }

    protected WebElement getTbiExpiredDate() {
        return Constant.WEBDRIVER.findElement(tbiExpiredDate);
    }

    protected WebElement getTbiAmount() {
        return Constant.WEBDRIVER.findElement(tbiAmount);
    }

    protected WebElement getTbiTicketPrice(){
        return Constant.WEBDRIVER.findElement(tbiTicketPrice);
    }

    //Methods
    public String getBookTicketTitle() {
        return this.getLblBookTicketTitle().getText();
    }

    public String getTicketBookedSuccessfullyTitle() {
        return this.getLblTicketBookSuccessfully().getText();
    }

    public void selectDepartDate(String dateOption) {
        Select select = new Select(getDdlDepartDate());
        select.selectByVisibleText(dateOption);
    }

    public void selectDepartFrom(String departFromOption) {
        Select select = new Select(getDdlDepartFrom());
        select.selectByVisibleText(departFromOption);
    }

    public void selectArriveAt(String arriveAtOption) {
        Select select = new Select(getDdlArriveAt());
        select.selectByVisibleText(arriveAtOption);
    }

    public void selectSeatType(String seatTypeOption) {
        Select select = new Select(getDdlSeatType());
        select.selectByVisibleText(seatTypeOption);
    }

    public void selectTicketAmount(String ticketAmountOption) {
        Select select = new Select(getDdlTicketAmount());
        select.selectByVisibleText(ticketAmountOption);
    }

    public String getSelectedDepartFromOption(){
        return this.getOptSelectedDepartFromOption().getText();
    }

    public String getSelectedArriveAtOption(){
        return this.getOptSelectedArriveAtOption().getText();
    }

    public String getDepartStation() {
        return this.getTbiDepartStation().getText();
    }

    public String getArriveStation() {
        return this.getTbiArriveStation().getText();
    }

    public String getSeatType() {
        return this.getTbiSeatType().getText();
    }

    public String getDepartDate() {
        return this.getTbiDepartDate().getText();
    }

    public String getBookTicketErrorMessage() {
        return this.getLblBookTicketErrorMsg().getText();
    }

    public String getTicketAmountErrorMessage() {
        return this.getLblTicketAmountErrorMsg().getText();
    }

    public String getBookTicketDate() {
        return this.getTbiBookDate().getText();
    }

    public String getExpiredDate() {
        return this.getTbiExpiredDate().getText();
    }

    public String getTicketPrice(){
        return this.getTbiTicketPrice().getText();
    }

    public String getBookedTicketAmount() {
        return this.getTbiAmount().getText();
    }

    public void bookTicketSubmit() {
        this.getBtnBookTicket().submit();
    }

    public void bookTicketMultipleTime(String depart, String arrive, String seatType, String amount, int times) throws InterruptedException {

        for(int i = 0; i < times; i++){
            int dayToBook = 7 + i;
            this.gotoBookTicketPage();
            this.selectDepartDate(Utilities.getDepartDate(dayToBook));
            this.selectDepartFrom(depart);
            Utilities.waitForElement();
            this.selectArriveAt(arrive);
            this.selectSeatType(seatType);
            this.selectTicketAmount(amount);
            this.bookTicketSubmit();
        }
    }

}
