package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    @Test(description = "TC16 - User can cancel a ticket", dataProviderClass = DataUtilities.class, dataProvider = "dataProviderTC14")
    public void TC16(String data) throws InterruptedException {
        String[] bookInfo = data.split(",");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("STEP-03: Book a ticket");
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.selectDepartDate(bookInfo[0]);
        bookTicketPage.selectDepartFrom(bookInfo[1]);
        Thread.sleep(1000);
        bookTicketPage.selectArriveAt(bookInfo[2]);
        bookTicketPage.selectSeatType(bookInfo[3]);
        bookTicketPage.selectTicketAmount(bookInfo[4]);
        bookTicketPage.bookTicketSubmit();

        System.out.println("STEP-04: Click on 'My Ticket Tab'");
        myTicketPage.gotoMyTicketPage();
        String deleteTicketValue = myTicketPage.getBtnDeleteTicket().getAttribute("onclick");
        Thread.sleep(1000);

        System.out.println("STEP-05: Click on ' Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.deleteTicket();

        System.out.println("STEP-06: Click on 'OK; button on Confirmation message 'Are you sure?'");
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();

        Assert.assertTrue(myTicketPage.isDeleteButtonDisappear() == true || (myTicketPage.isDeleteButtonDisappear() == false && deleteTicketValue != myTicketPage.getBtnDeleteTicket().getAttribute("onclick")),"Cancel Button is disappear");

    }
}
