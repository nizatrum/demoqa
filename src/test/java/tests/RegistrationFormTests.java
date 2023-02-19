package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    private final static String BASE_URL = "https://demoqa.com";
    private final static String REGISTRATION_FORM_URL = "/automation-practice-form";
    private final static String WINDOW_SIZE = "1920x1080";
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
    @Test
    void fillFormTest() {
        registrationPage.openRegistrationForm(REGISTRATION_FORM_URL);
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setGender(gender);
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.setDateOfBirth(birthMonth, birthYear);
        registrationPage.setSubjects(subjects);
        registrationPage.setHobbies(hobbies);
        registrationPage.uploadPicture(picture);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(state);
        registrationPage.setCity(city);
        registrationPage.removeInterceptingButtonElements();
        registrationPage.confirmForm();

        // asserts - проверки
        $(".modal-header").shouldBe(text("Thanks for submitting the form"));
        Assertions.assertEquals(
                String.format("%s %s", firstName, lastName),
                $x("//td[text()='Student Name']/following-sibling::td").getText());
        Assertions.assertEquals(
                email,
                $x(" //td[text()='Student Email']/following-sibling::td").getText());
        Assertions.assertEquals(
                gender,
                $x(" //td[text()='Gender']/following-sibling::td").getText());
        Assertions.assertEquals(
                phoneNumber,
                $x(" //td[text()='Mobile']/following-sibling::td").getText());
        Assertions.assertEquals(
                String.format("%s %s,%s", birthDay, birthMonth, birthYear),
                $x(" //td[text()='Date of Birth']/following-sibling::td").getText());
        //subjects
        Assertions.assertEquals(
                String.format("%s, %s", subjects[0], subjects[1]),
                $x(" //td[text()='Subjects']/following-sibling::td").getText());
        //hobbies
        Assertions.assertEquals(
                String.format("%s, %s", hobbies[0], hobbies[1]),
                $x(" //td[text()='Hobbies']/following-sibling::td").getText());
        //picture
        Assertions.assertEquals(
                picture.getName(),
                $x(" //td[text()='Picture']/following-sibling::td").getText());
        //address
        Assertions.assertEquals(
                currentAddress,
                $x(" //td[text()='Address']/following-sibling::td").getText());
        //state and city
        Assertions.assertEquals(
                String.format("%s %s", state, city),
                $x(" //td[text()='State and City']/following-sibling::td").getText());
    }
    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
