package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends AfterBefore{
    @Test
    public void TC07(){
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        String actualMsg = registerPage.register(Constant.UNREGISTERED_EMAIL, Constant.UNREGISTERED_PASSWORD, Constant.CONFIRM_PASSWORD,Constant.PID).getRegisterSuccessfullyMsg();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg,expectedMsg,"User cannot register with valid information");
    }
}
