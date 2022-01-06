package Railway;

import Common.Common.StringUtilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Register' Tab");
        homePage.gotoRegisterPage();

        System.out.println("STEP-03: Enter valid information into all field");
        registerPage.register(StringUtilities.generateRandomEmail(), Constant.UNREGISTERED_PASSWORD, Constant.CONFIRM_PASSWORD, StringUtilities.generatePID());

        String actualMsg = registerPage.getRegisterSuccessfullyMsg();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "User cannot register with valid information");
    }
}
