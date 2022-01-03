package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17 extends TestBase{
    @Test(description = "TC17 - User can't book more than 10 tickets", dataProviderClass = DataUtilities.class, dataProvider = "dataProviderTC17")
    public void TC17(String data) throws InterruptedException {
        String[] bookInfo = data.split(",");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("STEP-03: Click on 'Book Ticket' Tab");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("STEP-04: Book 10 Tickets");
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.selectDepartDate(bookInfo[0]);
        bookTicketPage.selectDepartFrom(bookInfo[1]);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(bookInfo[2]);
        bookTicketPage.selectSeatType(bookInfo[3]);
        bookTicketPage.selectTicketAmount(bookInfo[4]);
        bookTicketPage.bookTicketSubmit();

        System.out.println("STEP-05: Click on 'Book Ticket' Tab again");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("STEP-06: Book one more ticket");
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.selectDepartDate(bookInfo[0]);
        bookTicketPage.selectDepartFrom(bookInfo[1]);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(bookInfo[2]);
        bookTicketPage.selectSeatType(bookInfo[3]);
        bookTicketPage.selectTicketAmount(bookInfo[4]);
        bookTicketPage.bookTicketSubmit();

        String actualBookTicketErrorMsg = bookTicketPage.getBookTicketErrorMessage();
        String expectedBookTicketErrorMsg = bookTicketPage.getBookTicketErrorMessage();
        Assert.assertEquals(actualBookTicketErrorMsg,expectedBookTicketErrorMsg,"Book Ticket Error Message doesn't display correctly");

        String actualTicketAmountErrorMsg = bookTicketPage.getTicketAmountErrorMessage();
        String expectedTicketAmountErrorMsg = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualTicketAmountErrorMsg,expectedTicketAmountErrorMsg,"Ticket Amount Error Message doesn't display correctly");
    }
}
