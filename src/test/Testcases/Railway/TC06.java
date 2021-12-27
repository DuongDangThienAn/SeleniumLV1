package Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ContactPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test (description = "TC06 - User is redirected to Home page after logging out")
    public void TC06(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ContactPage contactPage = new ContactPage();

        System.out.println("STEP-01: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("STEP-02: Login with valid Email and Password");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String loginActualMsg = loginPage.getWelcomeMessage();
        String loginExpectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(loginActualMsg,loginExpectedMsg,"Welcome message is not displayed as expected");

        System.out.println("STEP-03:Click on 'Contact' Tab");
        contactPage.gotoContactPage();
        String contactPageActualMsg = contactPage.getContactPageTitle();
        System.out.println(contactPageActualMsg);
        String contactPageExpectedMsg = "Contact Information";
        Assert.assertEquals(contactPageActualMsg,contactPageExpectedMsg,"Contact Page doesn't display correctly");

        System.out.println("STEP-04:Click on 'Log out' Tab");
        contactPage.getLogOut();
        String actualCreateAccountText = homePage.getTextLnkCreateAccount();
        String expectedCreateAccountText = "create an account";
        Assert.assertEquals(actualCreateAccountText,expectedCreateAccountText,"Homepage doesn't display correctly");

        String actualLoginButtonText = homePage.getLoginButtonText();
        String expectedLoginButtonText = "Login";
        Assert.assertEquals(actualLoginButtonText,expectedLoginButtonText,"Logout Tab still appears after user logged out of the system");

    }
}
