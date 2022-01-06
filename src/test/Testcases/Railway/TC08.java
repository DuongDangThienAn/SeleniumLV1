package Railway;

import Common.Common.StringUtilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC08 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    String EMAIL = StringUtilities.generateRandomEmail();
    String PID = StringUtilities.generatePID();
    String password = Constant.UNREGISTERED_PASSWORD;
    String confirmPassword = Constant.CONFIRM_PASSWORD;
    TestPreCondition testPreCondition = new TestPreCondition();

    @BeforeMethod(description = "PRE-CONDITION: Create and activate a new account")
    public void setTestPreCondition(){
        testPreCondition.registerPreCondition(EMAIL, password, confirmPassword, PID);
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Login' Tab");
        loginPage.gotoLoginPage();

        System.out.println("STEP-03: Enter username and password of account hasn't been activated.");
        System.out.println("STEP-04: Click 'Login' button");
        loginPage.login(EMAIL, Constant.UNREGISTERED_PASSWORD);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "User can login with un-active account");
    }

}
