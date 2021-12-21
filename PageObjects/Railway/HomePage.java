package Railway;

import  Constant.Constant;

public class HomePage extends GeneralPage {

    //Locator

    //Elements

    //Methods

    //This is our methods that start our test cases
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
