package Common.Common;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtilities {
    public static String generateRandomEmail(){
        String randomString = RandomStringUtils.randomAlphanumeric(3);
        return "test" + randomString +"@gmail.com";
    }

    public static String generatePID(){
        String randomNum = RandomStringUtils.randomNumeric(12);
        return randomNum;
    }
}
