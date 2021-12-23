package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends AfterBefore {

    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank \"Username\" text box");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login("", Constant.PASSWORD).getEmailErrorMessage();
        String expectedMsg = "You must specify a username.";

        Assert.assertEquals(actualMsg, expectedMsg, "User can login successfully with email text box is left blank");
    }
}
