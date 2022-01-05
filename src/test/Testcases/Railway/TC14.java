package Railway;

import Common.Common.StringUtilities;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TC14 extends TestBase{
    @Test(description = "TC-14:User can book many tickets at a time", dataProvider = "data-provider14")
    public void TC14(String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        TestPreCondition testPreCondition = new TestPreCondition();

        String email = StringUtilities.generateRandomEmail();
        String PID = StringUtilities.generatePID();
        String password = Constant.UNREGISTERED_PASSWORD;
        String confirmPassword = Constant.CONFIRM_PASSWORD;
        String departDate = Utilities.getDepartDate();

        System.out.println("PRE-CONDITION");
        testPreCondition.registerPreCondition(email,password,confirmPassword,PID);

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(email, confirmPassword);

        System.out.println("STEP-03: Goto 'Book Ticket' Tab");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("STEP-04: Select Depart Date from the list");
        bookTicketPage.selectDepartDate(departDate);

        System.out.println("STEP-05: Select 'Nha Trang' for 'Depart from' and 'Sài Gòn' for 'Arrive at'.");
        bookTicketPage.selectDepartFrom(departFrom);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(arriveAt);

        System.out.println("STEP-06: Select 'Soft seat with air conditioner' for 'Seat type'");
        bookTicketPage.selectSeatType(seatType);

        System.out.println("STEP-07: Select '5' for 'Ticket amount'");
        bookTicketPage.selectTicketAmount(ticketAmount);

        System.out.println("STEP-08: Click on 'Book Ticket' button");
        bookTicketPage.bookTicketSubmit();

        String actualBookTicketSuccessfullyTitle = bookTicketPage.getTicketBookedSuccessfullyTitle();
        String expectedBookTicketSuccessfullyTitle = "Ticket Booked Successfully!";

        Assert.assertEquals(actualBookTicketSuccessfullyTitle,expectedBookTicketSuccessfullyTitle,"Title doesn't display when user have booked successfully");

        String actualDepartStation = bookTicketPage.getDepartStation();
        String expectedDepartStation = departFrom;

        Assert.assertEquals(actualDepartStation,expectedDepartStation,"Depart Station is not same as Depart Station that user have booked");

        String actualArriveStation = bookTicketPage.getArriveStation();
        String expectedArriveStation = arriveAt;

        Assert.assertEquals(actualArriveStation,expectedArriveStation, "Arrive Station is not same as Arrive Station that user have booked");

        String actualSeatType = bookTicketPage.getSeatType();
        String expectedSeatType = seatType;

        Assert.assertEquals(actualSeatType,expectedSeatType,"Seat Type is not same as Seat Type that user have booked");

        String actualDepartDate = bookTicketPage.getDepartDate();
        String expectedDepartDate = departDate;

        Assert.assertEquals(actualDepartDate,expectedDepartDate,"Depart Date is not same as Depart Date that user have booked");

        String actualTicketAmount = bookTicketPage.getBookedTicketAmount();
        String expectedTicketAmount = ticketAmount;

        Assert.assertEquals(actualTicketAmount,expectedTicketAmount,"TicketAmount is not same as Ticket Amount that user have booked");
    }

    @DataProvider(name="data-provider14")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath()+"\\src\\main\\java\\DataObjects\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String DepartFrom = dataTC14.get("DepartFrom").getAsString();
        String ArriveAt = dataTC14.get("ArriveAt").getAsString();
        String SeatType = dataTC14.get("SeatType").getAsString();
        String TicketAmount = dataTC14.get("TicketAmount").getAsString();

        Object[][] objects = new Object[][]{
                {DepartFrom,ArriveAt,SeatType,TicketAmount}
        };
        return objects;
    }
}
