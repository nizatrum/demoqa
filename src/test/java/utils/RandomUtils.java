package utils;

import java.util.Random;

public class RandomUtils {
    static String alphabetChars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    static String digitsChars = "1234567890";
    static String otherSymbolChars = "_-.";

    public static String getRandomString(int length, String parametr) {
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        if (parametr == "String") {
            for (int i = 0; i < length; i++) {
                result.append(alphabetChars.charAt(rnd.nextInt(alphabetChars.length() + 1)));
            }
        }
        else if (parametr == "Digit") {
            for (int i = 0; i < length; i++) {
                result.append(digitsChars.charAt(rnd.nextInt(digitsChars.length() + 1)));
            }
        }
        else if (parametr == "Symbol") {
            for (int i = 0; i < length; i++) {
                result.append(otherSymbolChars.charAt(rnd.nextInt(otherSymbolChars.length() + 1)));
            }
        }
        return result.toString();
    }


    public static String getRandomEmail() {
        String emailDomain = "@qa.guru";
        return getRandomString(10, "String") + emailDomain;
    }
}
