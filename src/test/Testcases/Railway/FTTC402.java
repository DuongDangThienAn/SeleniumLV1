package Railway;

import Common.Common.StringUtilities;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC402 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    TestPreCondition testPreCondition = new TestPreCondition();

    String email = StringUtilities.generateRandomEmail();
    String PID = StringUtilities.generatePID();
    String password = Constant.UNREGISTERED_PASSWORD;
    String confirmPassword = Constant.CONFIRM_PASSWORD;
    String filteredDepartDate = Utilities.getDepartDate(8);
    int timesToBookTicket = 7;

    @BeforeMethod(description = "PRE-CONDITION: Create and activate a new account")
    public void setTestPreCondition(){
        testPreCondition.registerPreCondition(email, password, confirmPassword, PID);
    }

    @Test(description = "FTTC402 - User can filter 'Manage ticket' table with both Depart Station and Arrive station",dataProvider = "data-providerFTTC403")
    public void FTTC402(String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {
        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(email, password);

        System.out.println("STEP-03: Book more than 6 tickets with different DepartDate");
        bookTicketPage.bookTicketMultipleTime(departFrom, arriveAt, seatType, ticketAmount,timesToBookTicket);

        System.out.println("STEP-04: Click on My Ticket Tab");
        myTicketPage.gotoMyTicketPage();

        System.out.println("STEP-05: Input one of Depart Date in 'Depart Station' and 'Arrive Station' text boxes");
        myTicketPage.selectDepartStationFilter(departFrom);
        myTicketPage.selectArriveStationFilter(arriveAt);

        System.out.println("STEP-06: Click 'Apply Filter' button");
        myTicketPage.clickApplyFilter();

        String[] actualDepartStations = myTicketPage.getActualDepartStations(departFrom,arriveAt);
        String[] actualArriveStations = myTicketPage.getActualArriveStations(departFrom,arriveAt);
        for(int i =0; i<timesToBookTicket;i++){
            String actualDepartStation = actualDepartStations[i];
            String expectedDepartStation = departFrom;

            Assert.assertEquals(actualDepartStation,expectedDepartStation,"Depart Station in table doesn't match with Depart Station in filter");

            String actualArriveStation = actualArriveStations[i];
            String expectedArriveStation = arriveAt;

            Assert.assertEquals(actualArriveStation,expectedArriveStation,"Arrive Station in table doesn't match with Arrive Station in filter");
        }

    }
    @DataProvider(name = "data-providerFTTC403")
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
