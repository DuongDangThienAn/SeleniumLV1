package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {


    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Login' Tab");
        loginPage.gotoLoginPage();

        System.out.println("STEP-03: Enter valid Email and Password");

        System.out.println("STEP-04: Click 'Login' button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

    }

}
