package Railway;

import Common.Common.StringUtilities;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    TestPreCondition testPreCondition = new TestPreCondition();

    String email = StringUtilities.generateRandomEmail();
    String PID = StringUtilities.generatePID();
    String password = Constant.UNREGISTERED_PASSWORD;
    String confirmPassword = Constant.CONFIRM_PASSWORD;
    String departDate = Utilities.getDepartDate();

    @BeforeMethod(description = "PRE-CONDITION: Create and activate a new account")
    public void setTestPreCondition(){
        testPreCondition.registerPreCondition(email,password,confirmPassword,PID);
    }

    @Test(description = "TC16 - User can cancel a ticket", dataProvider = "data-provider16")
    public void TC16(String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(email, password);

        System.out.println("STEP-03: Book a ticket");
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectDepartFrom(departFrom);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(arriveAt);
        bookTicketPage.selectSeatType(seatType);
        bookTicketPage.selectTicketAmount(ticketAmount);
        bookTicketPage.bookTicketSubmit();

        System.out.println("STEP-04: Click on 'My Ticket Tab'");
        myTicketPage.gotoMyTicketPage();
        String deleteTicketValue = myTicketPage.getBtnDeleteTicket(departFrom,arriveAt).getAttribute("onclick");
        Thread.sleep(1000);

        System.out.println("STEP-05: Click on ' Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.deleteTicket(departFrom,arriveAt);

        System.out.println("STEP-06: Click on 'OK; button on Confirmation message 'Are you sure?'");
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();

        Assert.assertTrue(myTicketPage.isDeleteButtonDisappear(departFrom,arriveAt) == true || (myTicketPage.isDeleteButtonDisappear(departFrom,arriveAt) == false && deleteTicketValue != myTicketPage.getBtnDeleteTicket(departFrom,arriveAt).getAttribute("onclick")), "Cancel Button is disappear");

    }

    @DataProvider(name = "data-provider16")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObjects\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String DepartFrom = dataTC14.get("DepartFrom").getAsString();
        String ArriveAt = dataTC14.get("ArriveAt").getAsString();
        String SeatType = dataTC14.get("SeatType").getAsString();
        String TicketAmount = dataTC14.get("TicketAmount").getAsString();

        Object[][] objects = new Object[][]{
                {DepartFrom, ArriveAt, SeatType, TicketAmount}
        };
        return objects;
    }
}
