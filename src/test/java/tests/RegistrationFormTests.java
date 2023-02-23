package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.DataTest.*;


public class RegistrationFormTests extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
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
}
