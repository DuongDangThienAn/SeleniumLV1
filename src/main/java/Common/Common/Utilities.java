package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static void scrollIntoView(WebElement scrollToElement) {
        WebElement element = scrollToElement;
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getDepartDate(int day) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime departDay = now.plusDays(day);
        return dateTimeFormatter.format(departDay);
    }

    public static void waitForElement() throws InterruptedException {
        Thread.sleep(1000);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }
}
