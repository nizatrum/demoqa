package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int length) {
        String chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(rnd.nextInt(chars.length() + 1)));
        }
        return result.toString();
    }


    public static int getRandomInt(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt(min, max);
    }

    /*public static String getRandomPhone(int length) {
        String resultNumber;
        for (int i = 0; i < length; i++) {
            resultNumber += getRandomInt()
        }
    }*/

    public static String getRandomEmail() {
        String emailDomain = "@qa.guru";
        return getRandomString(10) + emailDomain;
    }
}
