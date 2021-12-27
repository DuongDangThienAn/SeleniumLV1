package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test (description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Login' Tab");
        homePage.gotoLoginPage();

        System.out.println("STEP-03: Enter valid Email and invalid Password");
        loginPage.login(Constant.USERNAME,"thienan");

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"User can log in with invalid password");

    }
}
