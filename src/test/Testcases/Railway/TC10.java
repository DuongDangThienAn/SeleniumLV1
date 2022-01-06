package Railway;

import Common.Common.StringUtilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase{
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        TestPreCondition testPreCondition = new TestPreCondition();

        String email = StringUtilities.generateRandomEmail();
        String PID = StringUtilities.generatePID();
        String password = Constant.UNREGISTERED_PASSWORD;
        String confirmPassword = Constant.CONFIRM_PASSWORD;

        System.out.println("PRE-CONDITION: Create and activate a new account");
        testPreCondition.registerPreCondition(email,password,confirmPassword,PID);

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Register' Tab");
        registerPage.gotoRegisterPage();


        System.out.println("STEP-03: Enter information of the created account in Pre-condition");
        System.out.println("STEP-04: Click on 'Register' button");
        registerPage.register(email, password, confirmPassword,PID);

        String actualMsg = registerPage.getRegisterErrorMessage();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg,expectedMsg,"Error Message doesn't display when user registers with registered account");

    }
}
