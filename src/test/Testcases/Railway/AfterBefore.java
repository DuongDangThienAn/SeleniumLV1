package Railway;

import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AfterBefore {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver","D:\\SATT\\chromedriver\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
//        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");

        Constant.WEBDRIVER.quit();

    }
}
