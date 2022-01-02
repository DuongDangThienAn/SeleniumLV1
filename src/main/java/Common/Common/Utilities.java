package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utilities {

    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }

    public static void scrollIntoView(){
        WebElement element = Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'Web hosting by Somee.com')]"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);",element);
    }

}
