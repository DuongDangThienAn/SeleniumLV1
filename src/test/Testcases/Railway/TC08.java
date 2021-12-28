package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase {

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        final String EMAIL = Constant.generateRandomEmail();
        final String PID = Constant.generatePID();

        System.out.println("PRE-CONDITION");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.register(EMAIL,Constant.UNREGISTERED_PASSWORD,Constant.CONFIRM_PASSWORD,PID);

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Login' Tab");
        loginPage.gotoLoginPage();

        System.out.println("STEP-03: Enter username and password of account hasn't been activated.");
        System.out.println("STEP-04: Click 'Login' button");
        loginPage.login(EMAIL,Constant.UNREGISTERED_PASSWORD);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"User can login with un-active account");
    }

}
