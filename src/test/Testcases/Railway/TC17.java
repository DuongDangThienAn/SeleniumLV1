package Railway;

import Common.Common.StringUtilities;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TestPreCondition testPreCondition = new TestPreCondition();

    String email = StringUtilities.generateRandomEmail();
    String PID = StringUtilities.generatePID();
    String password = Constant.UNREGISTERED_PASSWORD;
    String confirmPassword = Constant.CONFIRM_PASSWORD;
    String departDate = Utilities.getDepartDate(7);

    @BeforeMethod(description = "PRE-CONDITION: Create and activate a new account")
    public void setTestPreCondition(){
        testPreCondition.registerPreCondition(email,password,confirmPassword,PID);
    }

    @Test(description = "TC17 - User can't book more than 10 tickets", dataProvider = "data-provider17")
    public void TC17(String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {

        System.out.println("PRE-CONDITION");
        testPreCondition.registerPreCondition(email, password, confirmPassword, PID);

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(email, confirmPassword);

        System.out.println("STEP-03: Goto 'Book Ticket' Tab");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("STEP-04: Book 10 Tickets");
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectDepartFrom(departFrom);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(arriveAt);
        bookTicketPage.selectSeatType(seatType);
        bookTicketPage.selectTicketAmount(ticketAmount);
        bookTicketPage.bookTicketSubmit();

        System.out.println("STEP-05: Click on 'Book Ticket' Tab again");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("STEP-06: Book one more ticket");
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectDepartFrom(departFrom);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(arriveAt);
        bookTicketPage.selectSeatType(seatType);
        bookTicketPage.selectTicketAmount(ticketAmount);
        bookTicketPage.bookTicketSubmit();

        String actualBookTicketErrorMsg = bookTicketPage.getBookTicketErrorMessage();
        String expectedBookTicketErrorMsg = bookTicketPage.getBookTicketErrorMessage();
        Assert.assertEquals(actualBookTicketErrorMsg, expectedBookTicketErrorMsg, "Book Ticket Error Message doesn't display correctly");

        String actualTicketAmountErrorMsg = bookTicketPage.getTicketAmountErrorMessage();
        String expectedTicketAmountErrorMsg = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualTicketAmountErrorMsg, expectedTicketAmountErrorMsg, "Ticket Amount Error Message doesn't display correctly");
    }

    @DataProvider(name = "data-provider17")
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
