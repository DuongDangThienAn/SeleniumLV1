package Common.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
public class Constant   {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/";
    public static final String USERNAME = "anthienduong2000@gmail.com";
    public static final String PASSWORD = "Duongthienan82";

    public static final String UNREGISTERED_PASSWORD = "Duongthienan2000";
    public static final String CONFIRM_PASSWORD = "Duongthienan2000";

    public static final String NEW_PASSWORD = "a123:\"/{}!@$\\";
    public static final String CONFIRM_CHANGE_PASSWORD = "b456:\"/{}!@$\\";

    public static String generateRandomEmail(){
        String randomString = RandomStringUtils.randomAlphanumeric(3);
        return "test" + randomString +"@gmail.com";
    }

    public static String generatePID(){
        String randomNum = RandomStringUtils.randomNumeric(12);
        return randomNum;
    }

    public static void main(String[] args) {
        System.out.println(generatePID());
    }
}
