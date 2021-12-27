package Railway;


import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {

    @Test (description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Click on 'Login' Tab");
        homePage.gotoLoginPage();

        System.out.println("STEP-03: Enter valid information into 'Username' text box except 'Password' text box.");
        System.out.println("STEP-04: Click 'Login' button");
        loginPage.login(Constant.USERNAME, "thienan");

        System.out.println("STEP-05: Repeat step 3 three more times.");
        loginPage.loginMultipleTimes(Constant.USERNAME, "thienan", 3);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "System doesn't show message when user enters wrong password several times");
    }
}
