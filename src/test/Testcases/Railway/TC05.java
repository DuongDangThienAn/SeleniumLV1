package Railway;


import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends AfterBefore {

    @Test
    public void TC05(){
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.loginLoop(Constant.USERNAME, "thienan", 3);
        String actualMsg = loginPage.login(Constant.USERNAME,"thienan").getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "System doesn't show message when user enters wrong password several times");
    }
}
