package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import java.io.File;


public class RegistrationFormTests {
    //constants
    private final static String BASE_URL = "https://demoqa.com";
    private final static String REGISTRATION_FORM_URL = "/automation-practice-form";
    private final static String WINDOW_SIZE = "1920x1080";

    //create objects
    RegistrationPage registrationPage = new RegistrationPage();

    //variables static mode, but we don't create object RegistrationFormTests
    public static String firstName = "Timur";
    public static String lastName = "Murtazin";
    public static String email = "mytestmail@company.com";
    public static String gender = "Male";
    public static String phoneNumber = "1234567891";
    public static String birthDay = "21";
    public static String birthMonth = "March";
    public static String birthYear = "1995";
    public static String[] subjects = new String[] {"Maths", "Social Studies"};
    public static String[] hobbies = new String[] {"Sports", "Music"};
    public static File picture = new File("src/test/resources/neo.jpg");
    public static String currentAddress = "some address";
    public static String state = "NCR";
    public static String city = "Delhi";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = WINDOW_SIZE;
    }
    @BeforeEach
    void beforeEach() {
        registrationPage.openRegistrationForm(REGISTRATION_FORM_URL)
                        .removeInterceptingButtonElements();
    }
    @Test
    void fillFormTest() {
        registrationPage.setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setGender(gender)
                        .setPhoneNumber(phoneNumber)
                        .setDateOfBirth(birthMonth, birthYear)
                        .setSubjects(subjects)
                        .setHobbies(hobbies)
                        .uploadPicture(picture)
                        .setCurrentAddress(currentAddress)
                        .setState(state)
                        .setCity(city)
                        .confirmForm();

        // checks
        registrationPage.checkForm("Student Name", firstName + " " + lastName)
                        .checkForm("Student Email", email)
                        .checkForm("Gender", gender)
                        .checkForm("Mobile", phoneNumber)
                        .checkForm("Date of Birth", String.format("%s %s,%s", birthDay, birthMonth, birthYear))
                        .checkForm("Subjects", String.format("%s, %s", subjects[0], subjects[1]))
                        .checkForm("Hobbies", String.format("%s, %s", hobbies[0], hobbies[1]))
                        .checkForm("Picture", picture.getName())
                        .checkForm("Address", currentAddress)
                        .checkForm("State and City", String.format("%s %s", state, city));
    }
    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
