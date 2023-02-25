package tests;

import java.io.File;

import static utils.RandomUtils.*;

public class DataTestWithVariablesRandom {

    //variables static mode, but we don't create object RegistrationFormTests
    public static String firstName = getRandomString(7, "String");
    public static String lastName = getRandomString(7, "String");
    public static String email = getRandomEmail();
    public static String gender = "Male";
    public static String phoneNumber = getRandomString(11, "Digit");
    public static String birthDay = getRandomString(2, "Digit");;
    public static String birthMonth = "March";
    public static String birthYear = getRandomString(4, "Digit");;
    public static String[] subjects = new String[]{"Maths", "Social Studies"};
    public static String[] hobbies = new String[]{"Sports", "Music"};
    public static File picture = new File("src/test/resources/neo.jpg");
    public static String currentAddress = getRandomString(20, "String");
    public static String state = "NCR";
    public static String city = "Delhi";
}
