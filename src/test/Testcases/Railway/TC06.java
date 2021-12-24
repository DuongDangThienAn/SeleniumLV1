package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ContactPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends AfterBefore{
    @Test
    public void TC06(){
        HomePage homePage =new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String loginActualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String loginExpectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(loginActualMsg,loginExpectedMsg,"Welcome message is not displayed as expected");

        ContactPage contactPage = new ContactPage();
        contactPage.gotoContactPage();

        String contactPageActualMsg = contactPage.getContactPageTitle();
        System.out.println(contactPageActualMsg);
        String contactPageExpectedMsg = "Contact Information";

        Assert.assertEquals(contactPageActualMsg,contactPageExpectedMsg,"Contact Page doesn't display correctly");

        contactPage.getLogOut();
        String actualCreateAccountText = homePage.getTextLnkCreateAccount();
        String expectedCreateAccountText = "create an account";

        Assert.assertEquals(actualCreateAccountText,expectedCreateAccountText,"Homepage doesn't display correctly");


    }
}
