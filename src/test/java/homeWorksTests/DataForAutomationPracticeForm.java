package homeWorksTests;

import java.io.File;

public abstract class DataForAutomationPracticeForm {
    protected final static String BASE_URL = "https://demoqa.com";
    protected final static String WINDOW_SIZE = "1920x1080";
    protected String firstName = "Timur";
    protected String lastName = "Murtazin";
    protected String email = "mytestmail@company.com";
    protected String gender = "Male";
    protected String phoneNumber = "1234567891"; //max - 10 symbol
    protected byte birthDay = 21;
    protected String birthMonth = "March";
    protected Short birthYear = 1995;

    protected String subjects = "Algorithms";
    protected String[] hobbies = new String[] {"Sports", "Music"};
    protected File picture = new File("src/test/resources/neo.jpg");
    protected String currentAddress = "some address";
    protected String state = "NCR";
    protected String city = "Delhi";
}
