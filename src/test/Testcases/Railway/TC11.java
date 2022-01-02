package Railway;

import Common.Common.StringUtilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase{
    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Register' Tab");
        registerPage.gotoRegisterPage();

        System.out.println("STEP-03: Enter valid email address and leave other fields empty");
        System.out.println("STEP-04: Click on 'Register' button");
        registerPage.register(StringUtilities.generateRandomEmail(),"","","");

        String actualPasswordFieldError = registerPage.getPasswordFieldErrorMsg();
        String expectedPasswordFieldError = "Invalid password length";

        Assert.assertEquals(actualPasswordFieldError,expectedPasswordFieldError,"Password Error doesn't displayed correctly");

        String actualPIDFieldError = registerPage.getPIDFieldErrorMsg();
        String expectedPIDFieldError = "Invalid ID length";

        Assert.assertEquals(actualPIDFieldError,expectedPIDFieldError,"PID Error doesn't displayed correctly");

        String actualErrorRegisterMsg = registerPage.getRegisterErrorMessage();
        String expectedErrorRegisterMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualErrorRegisterMsg,expectedErrorRegisterMsg,"Error Register Message doesn't display correctly");

    }
}
