package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {

    @Test (description = "TC02 - User can't login with blank 'Username' text box")
    public void TC02(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Login' Tab");
        homePage.gotoLoginPage();

        System.out.println("STEP-03: User doesn't type any words into 'Username' text box but enter valid information into 'Password' text box");

        System.out.println("STEP-04: Click 'Login' button");
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getEmailErrorMessage();
        String expectedMsg = "You must specify a username.";

        Assert.assertEquals(actualMsg, expectedMsg, "User can login successfully with email text box is left blank");
    }
}
