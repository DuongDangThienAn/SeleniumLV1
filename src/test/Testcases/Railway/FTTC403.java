package Railway;

import Common.Common.StringUtilities;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC403 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimeTablePage timeTablePage = new TimeTablePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TestPreCondition testPreCondition = new TestPreCondition();

    String email = StringUtilities.generateRandomEmail();
    String PID = StringUtilities.generatePID();
    String password = Constant.UNREGISTERED_PASSWORD;
    String confirmPassword = Constant.CONFIRM_PASSWORD;

    @BeforeMethod(description = "PRE-CONDITION: Create and activate a new account")
    public void setTestPreCondition(){
        testPreCondition.registerPreCondition(email, password, confirmPassword, PID);
    }

    @Test(description = "FTTC403 - User can book ticket from Timetable" ,dataProvider = "data-providerFTTC403")
    public void FTTC403(String departStation, String arriveStation, String departTime){
        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(email, password);

        System.out.println("STEP-03: Click on 'Time Table' tab");
        timeTablePage.gotoTimeTablePage();
        String expectedTicketPriceTableTitle = "Ticket price from " + departStation + " to " + arriveStation;

        System.out.println("STEP-04: Click on 'Book Ticket' link of the route from 'Huế' to 'Nha Trang'");
        Utilities.scrollIntoView(timeTablePage.getLnkBookTicket(departStation,arriveStation,departTime));
        timeTablePage.clickBookTicketLink(departStation, arriveStation, departTime);

        String actualDepartStation = bookTicketPage.getSelectedDepartFromOption();
        String expectedDepartStation = departStation;

        Assert.assertEquals(actualDepartStation,expectedDepartStation,"Depart Station doesn't match with Depart Station that user have selected before");

        String actualArriveStation = bookTicketPage.getSelectedArriveAtOption();
        String expectedArriveStation = arriveStation;

        Assert.assertEquals(actualArriveStation,expectedArriveStation,"Arrive Station doesn't match with Arrive Station that user have selected before");
    }

    @DataProvider(name = "data-providerFTTC403")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObjects\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC403 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String DepartStation = dataFTTC403.get("DepartStation").getAsString();
        String ArriveStation = dataFTTC403.get("ArriveStation").getAsString();
        String DepartTime = dataFTTC403.get("DepartTime").getAsString();

        Object[][] objects = new Object[][]{
                {DepartStation, ArriveStation, DepartTime}
        };
        return objects;
    }
}
