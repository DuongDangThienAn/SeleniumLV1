package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends AfterBefore{
    @Test
    public void TC04(){
        System.out.println("TC-04 - User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        String actualMsg = bookTicketPage.getBookTicketTitle();
        String expectedMsg = "Book ticket";

        Assert.assertEquals(actualMsg,expectedMsg,"User cannot be navigate to Book Ticket Tab");



    }
}
