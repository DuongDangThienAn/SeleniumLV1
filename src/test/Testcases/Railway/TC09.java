package Railway;

import Common.Common.StringUtilities;
import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase{
    @Test(description = "TC09 - User can't change password when 'New Password' and 'Confirm Password' are different.")
    public void TC09(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        final String EMAIL = StringUtilities.generateRandomEmail();
        final String PID = StringUtilities.generatePID();

        System.out.println("PRE-CONDITION: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.register(EMAIL, Constant.UNREGISTERED_PASSWORD, Constant.CONFIRM_PASSWORD,PID);

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.login(EMAIL,Constant.UNREGISTERED_PASSWORD);

        System.out.println("STEP-03: Click on 'Change Password' tab");
        changePasswordPage.gotoChangePasswordPage();

        System.out.println("STEP-04: Enter valid information into 'Current Password' text box but enter 'a123:\"/{}!@$\\' into 'New Password' textbox and 'b456:\"/{}!@$\\' into 'Confirm Password' text box.");
        changePasswordPage.changePassword(Constant.UNREGISTERED_PASSWORD,Constant.NEW_PASSWORD,Constant.CONFIRM_CHANGE_PASSWORD);

        String actualMsg = changePasswordPage.getChangePasswordErrorMessage();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";

        String actualConfirmPasswordErrorMsg = changePasswordPage.getConfirmPasswordErrorMsg();
        String expectedConfirmPasswordErrorMsg = "The password confirmation does not match the new password.";

        Assert.assertEquals(actualMsg,expectedMsg,"Error message doesn't display when 'Confirm Password' didn't matches with 'New Password'");
        Assert.assertEquals(actualConfirmPasswordErrorMsg,expectedConfirmPasswordErrorMsg,"Error message doesn't display when 'Confirm Password' didn't matches with 'New Password'");

    }
}
