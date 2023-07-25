package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static tests.DataTest.*;


public class RegistrationFormTests extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        step("Открыть https://demoqa.com/automation-practice-form", () -> {
            registrationPage.openPage();
        });

        step("Заполнить поле \"First Name\" значением " + firstName, () -> {
            registrationPage.setFirstName(firstName);
        });

        step("Заполнить поле \"Last Name\" значением " + lastName, () -> {
            registrationPage.setLastName(lastName);
        });

        step("Заполнить поле \"Email\" значением " + email, () -> {
            registrationPage.setEmail(email);
        });

        step("Выбрать \"Gender\" " + email, () -> {
            registrationPage.setGender(gender);
        });

        step("Заполнить поле \"Mobile Number\" значением " + phoneNumber, () -> {
            registrationPage.setPhoneNumber(phoneNumber);
        });

        step("Выбрать дату рождения " + birthDay, () -> {
            registrationPage.setDateOfBirth(birthDay, birthMonth, birthYear);
        });

        step("Выбрать в выпадающем списке \"Subject\" " + subject, () -> {
            registrationPage.setSubjects(subject);
        });

        step("Выбрать \"Hobbies\" " + hobbies, () -> {
            registrationPage.setHobbies(hobbies);
        });

        step("Загрузить \"Picture\"", () -> {
            registrationPage.uploadPicture(picture);
        });

        step("Заполнить поле \"Current Address\" значением " + currentAddress, () -> {
            registrationPage.setCurrentAddress(currentAddress);
        });

        step("Выбрать из выпадающего списка \"State\" " + state, () -> {
            registrationPage.setState(state);
        });

        step("Выбрать из выпадающего списка \"City\" " + city, () -> {
            registrationPage.setCity(city);
        });

        step("Нажать на \"Submit\"" , () -> {
            registrationPage.confirmForm();
        });

        step("Проверка заполнения полей", () -> {
            registrationPage.checkForm("Student Name", firstName + " " + lastName)
                    .checkForm("Student Email", email)
                    .checkForm("Gender", gender)
                    .checkForm("Mobile", phoneNumber)
                    .checkForm("Date of Birth", String.format("%s %s,%s", birthDay, birthMonth, birthYear))
                    .checkForm("Subjects", subject)
                    .checkForm("Hobbies", String.format("%s, %s", hobbies[0], hobbies[1]))
                    .checkForm("Picture", picture.getName())
                    .checkForm("Address", currentAddress)
                    .checkForm("State and City", String.format("%s %s", state, city));
        });
    }
}
