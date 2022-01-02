package Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TicketPricePage;
import PageObjects.Railway.TimeTablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TC15 extends TestBase{
    @Test(description = "TC15 - 'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page", dataProviderClass = DataUtilities.class, dataProvider = "dataProviderTC15")
    public void TC15(HashMap<String, String> ticketPriceData){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        TicketPricePage ticketPricePage = new TicketPricePage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("STEP-03: Click on 'Time Table' tab");
        timeTablePage.gotoTimeTablePage();
        String expectedTicketPriceTableTitle = "Ticket price from " + timeTablePage.getDepartStation() + " to " + timeTablePage.getArriveStation();


        System.out.println("STEP-04: Click on 'check price' link of the route from 'Đà Nẵng' to 'Sài Gòn'");
        Utilities.scrollIntoView();
        timeTablePage.clickCheckPrice();

        String[] actualSeatTypes = ticketPricePage.getSeatTypeList();
        String[] actualTicketPrices = ticketPricePage.getTicketPriceList();
        for(int i = 0; i < actualSeatTypes.length; i++) {
            String actualMsg = actualTicketPrices[i];
            String expectedMsg = ticketPriceData.get(actualSeatTypes[i]);
            Assert.assertEquals(actualMsg, expectedMsg, "Ticket Prices is not displayed correctly");
        }

        String actualTicketPriceTableTitle = ticketPricePage.getTableTitle();
        Assert.assertEquals(actualTicketPriceTableTitle,expectedTicketPriceTableTitle,"Table Title is not displayed correctly");
    }
}
