package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase{
    @Test(description = "TC-14:User can book many tickets at a time", dataProviderClass = DataUtilities.class, dataProvider = "dataProviderTC14")
    public void TC14(String data) throws InterruptedException {
        String[] bookInfo = data.split(",");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("STEP-03: Goto 'Book Ticket' Tab");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("STEP-04: Select Depart Date from the list");
        bookTicketPage.selectDepartDate(bookInfo[0]);

        System.out.println("STEP-05: Select 'Nha Trang' for 'Depart from' and 'Sài Gòn' for 'Arrive at'.");
        bookTicketPage.selectDepartFrom(bookInfo[1]);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(bookInfo[2]);

        System.out.println("STEP-06: Select 'Soft seat with air conditioner' for 'Seat type'");
        bookTicketPage.selectSeatType(bookInfo[3]);

        System.out.println("STEP-07: Select '5' for 'Ticket amount'");
        bookTicketPage.selectTicketAmount(bookInfo[4]);

        System.out.println("STEP-08: Click on 'Book Ticket' button");
        bookTicketPage.bookTicketSubmit();

        String actualBookTicketSuccessfullyTitle = bookTicketPage.getTicketBookedSuccessfullyTitle();
        String expectedBookTicketSuccessfullyTitle = "Ticket Booked Successfully!";

        Assert.assertEquals(actualBookTicketSuccessfullyTitle,expectedBookTicketSuccessfullyTitle,"Title doesn't display when user have booked successfully");

        String actualDepartStation = bookTicketPage.getDepartStation();
        String expectedDepartStation = bookInfo[1];

        Assert.assertEquals(actualDepartStation,expectedDepartStation,"Depart Station is not same as Depart Station that user have booked");

        String actualArriveStation = bookTicketPage.getArriveStation();
        String expectedArriveStation = bookInfo[2];

        Assert.assertEquals(actualArriveStation,expectedArriveStation, "Arrive Station is not same as Arrive Station that user have booked");

        String actualSeatType = bookTicketPage.getSeatType();
        String expectedSeatType = bookInfo[3];

        Assert.assertEquals(actualSeatType,expectedSeatType,"Seat Type is not same as Seat Type that user have booked");

        String actualDepartDate = bookTicketPage.getDepartDate();
        String expectedDepartDate = bookInfo[0];

        Assert.assertEquals(actualDepartDate,expectedDepartDate,"Depart Date is not same as Depart Date that user have booked");

        String actualTicketAmount = bookTicketPage.getBookedTicketAmount();
        String expectedTicketAmount = bookInfo[4];

        Assert.assertEquals(actualTicketAmount,expectedTicketAmount,"TicketAmount is not same as Ticket Amount that user have booked");
    }
}
