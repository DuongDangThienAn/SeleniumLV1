package Common.Common;

import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Timestamp;

public class StringUtilities {
    public static String generateRandomEmail() {
        String randomString = RandomStringUtils.randomAlphanumeric(3);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "test" + randomString + timestamp.getTime() + "@gmail.com";
    }

    public static String generatePID() {
        String randomNum = RandomStringUtils.randomNumeric(12);
        return randomNum;
    }
}
