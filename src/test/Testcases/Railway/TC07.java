package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test (description = "TC07 - User can create new account")
    public void TC07(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Register' Tab");
        homePage.gotoRegisterPage();

        System.out.println("STEP-03: Enter valid information into all field");
        registerPage.register(Constant.generateRandomEmail(),Constant.PASSWORD,Constant.PASSWORD,Constant.generatePID());

        String actualMsg = registerPage.getRegisterSuccessfullyMsg();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg,expectedMsg,"User cannot register with valid information");
    }
}