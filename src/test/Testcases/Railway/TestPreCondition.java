package Railway;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class TestPreCondition {
    public void registerPreCondition(String email,String password,String confirm_password, String PID){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.register(email,password,confirm_password,PID);

    }
}
