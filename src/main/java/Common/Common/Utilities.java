package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }

    public static void scrollIntoView(){
        WebElement element = Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'Web hosting by Somee.com')]"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static String getDepartDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime departDay = now.plusDays(7);
        return  dateTimeFormatter.format(departDay);
    }

}
