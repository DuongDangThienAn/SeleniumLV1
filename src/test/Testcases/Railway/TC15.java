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

public class TC15 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimeTablePage timeTablePage = new TimeTablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TestPreCondition testPreCondition = new TestPreCondition();

    String email = StringUtilities.generateRandomEmail();
    String PID = StringUtilities.generatePID();
    String password = Constant.UNREGISTERED_PASSWORD;
    String confirmPassword = Constant.CONFIRM_PASSWORD;

    @BeforeMethod(description = "PRE-CONDITION: Create and activate a new account")
    public void setTestPreCondition(){
        testPreCondition.registerPreCondition(email,password,confirmPassword,PID);
    }

    @Test(description = "TC15 - 'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page", dataProvider = "data-provider15")
    public void TC15(String departStation, String arriveStation, String HSColumn,String SSColumn,String SSCColumn,String HBColumn,String SBColumn,String SBCColumn){

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(email, password);

        System.out.println("STEP-03: Click on 'Time Table' tab");
        timeTablePage.gotoTimeTablePage();
        String expectedTicketPriceTableTitle = "Ticket price from " + departStation + " to " + arriveStation;

        System.out.println("STEP-04: Click on 'check price' link of the route from 'Đà Nẵng' to 'Sài Gòn'");
        Utilities.scrollIntoView(timeTablePage.getLnkCheckPrice(departStation,arriveStation));
        timeTablePage.clickCheckPrice(departStation, arriveStation);

        String[] actualTicketPrices = ticketPricePage.getTicketPriceList();

        String actualHSColumn = actualTicketPrices[0];
        String expectHSColumn = HSColumn;
        Assert.assertEquals(actualHSColumn,expectHSColumn,"HS Column doesn't display correctly");

        String actualSSColumn = actualTicketPrices[1];
        String expectSSColumn = SSColumn;
        Assert.assertEquals(actualSSColumn,expectSSColumn,"SS Column doesn't display correctly");

        String actualSSCColumn = actualTicketPrices[2];
        String expectSSCColumn = SSCColumn;
        Assert.assertEquals(actualSSCColumn,expectSSCColumn,"SSC Column doesn't display correctly");

        String actualHBColumn = actualTicketPrices[3];
        String expectHBColumn = HBColumn;
        Assert.assertEquals(actualHBColumn,expectHBColumn,"HB Column doesn't display correctly");

        String actualSBColumn = actualTicketPrices[4];
        String expectSBColumn = SBColumn;
        Assert.assertEquals(actualSBColumn,expectSBColumn,"SB Column doesn't display correctly");

        String actualSBCColumn = actualTicketPrices[5];
        String expectSBCColumn = SBCColumn;
        Assert.assertEquals(actualSBCColumn,expectSBCColumn,"SBC Column doesn't display correctly");

        String actualTicketPriceTableTitle = ticketPricePage.getTableTitle();
        Assert.assertEquals(actualTicketPriceTableTitle,expectedTicketPriceTableTitle,"Table Title is not displayed correctly");
    }

    @DataProvider(name = "data-provider15")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath()+"\\src\\main\\java\\DataObjects\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC15.get("DepartStation").getAsString();
        String arriveStation = dataTC15.get("ArriveStation").getAsString();
        String HSColumn = dataTC15.get("HS").getAsString();
        String SSColumn = dataTC15.get("SS").getAsString();
        String SSCColumn = dataTC15.get("SSC").getAsString();
        String HBColumn = dataTC15.get("HB").getAsString();
        String SBColumn = dataTC15.get("SB").getAsString();
        String SBCColumn = dataTC15.get("SBC").getAsString();

        Object[][] objects = new Object[][]{
                {departStation, arriveStation, HSColumn, SSColumn, SSCColumn, HBColumn, SBColumn, SBCColumn}
        };

        return objects;
    }
}
