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

public class FTTC401 extends TestBase{
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
        testPreCondition.registerPreCondition(email, password, confirmPassword, PID);
    }

    @Test(description = "FTTC401 - User can book 1 ticket at a time", dataProvider = "data-providerFTTC401")
    public void FTTC401(String departFrom, String arriveAt, String seatType, String ticketAmount, String ticketPrice) throws InterruptedException {

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(email, confirmPassword);

        System.out.println("STEP-03: Goto 'Book Ticket' Tab");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("STEP-04: Select Depart Date from the list");
        bookTicketPage.selectDepartDate(departDate);

        System.out.println("STEP-05: Select 'Huế' for 'Depart from' and 'Nha Trang' for 'Arrive at'.");
        bookTicketPage.selectDepartFrom(departFrom);
        Utilities.waitForElement();
        bookTicketPage.selectArriveAt(arriveAt);

        System.out.println("STEP-06: Select 'Soft seat with air conditioner' for 'Seat type'");
        bookTicketPage.selectSeatType(seatType);

        System.out.println("STEP-07: Select '4' for 'Ticket amount'");
        bookTicketPage.selectTicketAmount(ticketAmount);

        System.out.println("STEP-08: Click on 'Book Ticket' button");
        bookTicketPage.bookTicketSubmit();

        String actualBookTicketSuccessfullyTitle = bookTicketPage.getTicketBookedSuccessfullyTitle();
        String expectedBookTicketSuccessfullyTitle = "Ticket Booked Successfully!";

        Assert.assertEquals(actualBookTicketSuccessfullyTitle, expectedBookTicketSuccessfullyTitle, "Title doesn't display when user have booked successfully");

        String actualDepartStation = bookTicketPage.getDepartStation();
        String expectedDepartStation = departFrom;

        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not same as Depart Station that user have booked");

        String actualArriveStation = bookTicketPage.getArriveStation();
        String expectedArriveStation = arriveAt;

        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not same as Arrive Station that user have booked");

        String actualSeatType = bookTicketPage.getSeatType();
        String expectedSeatType = seatType;

        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat Type is not same as Seat Type that user have booked");

        String actualDepartDate = bookTicketPage.getDepartDate();
        String expectedDepartDate = departDate;

        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart Date is not same as Depart Date that user have booked");

        String actualTicketAmount = bookTicketPage.getBookedTicketAmount();
        String expectedTicketAmount = ticketAmount;

        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket Amount is not same as Ticket Amount that user have booked");

        String actualTicketPrice = bookTicketPage.getTicketPrice();
        String expectedTicketPrice = ticketPrice;

        Assert.assertEquals(actualTicketPrice, expectedTicketPrice, "Ticket Price is not same as Ticket Price that user have booked");
    }

    @DataProvider(name = "data-providerFTTC401")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObjects\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC401 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String DepartFrom = dataFTTC401.get("DepartFrom").getAsString();
        String ArriveAt = dataFTTC401.get("ArriveAt").getAsString();
        String SeatType = dataFTTC401.get("SeatType").getAsString();
        String TicketAmount = dataFTTC401.get("TicketAmount").getAsString();
        String TicketPrice = dataFTTC401.get("TicketPrice").getAsString();

        Object[][] objects = new Object[][]{
                {DepartFrom, ArriveAt, SeatType, TicketAmount, TicketPrice}
        };
        return objects;
    }

}
