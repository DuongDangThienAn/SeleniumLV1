package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    @Test(description = "TC-04 - User is redirected to Book ticket page after logging in")
    public void TC04() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        System.out.println("STEP-03: Login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoBookTicketPage();

        String actualMsg = bookTicketPage.getBookTicketTitle();
        String expectedMsg = "Book ticket";

        Assert.assertEquals(actualMsg, expectedMsg, "User cannot be navigate to Book Ticket Tab");
    }
}
