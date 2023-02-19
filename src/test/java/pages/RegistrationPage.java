package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    //create component objects
    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement phoneNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesInput = $("#hobbiesWrapper");
    SelenideElement pictureLoading = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateInput = $("#state");
    SelenideElement cityInput = $("#city");
    SelenideElement stateAndCityWrapper = $("#stateCity-wrapper");
    SelenideElement submitButton = $("#submit");
    SelenideElement resultTable = $(".table-responsive");
    //actions
    public void removeInterceptingButtonElements() {
        executeJavaScript("$('footer').hide()");
        executeJavaScript("$('#close-fixedban').parent().hide();");
    }
    public RegistrationPage openRegistrationForm(String url) {
        open(url);
        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }
    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }
    public RegistrationPage setDateOfBirth(String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.datePadding(month, year);
        return this;
    }
    public RegistrationPage setSubjects(String[] subjects) {
        for (String subject : subjects)
            subjectsInput.setValue(subject).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String[] hobbies) {
        for (String hobby : hobbies)
            hobbiesInput.$(byText(hobby)).click();
        return this;
    }
    public RegistrationPage uploadPicture(File picture) {
        pictureLoading.uploadFile(picture);
        return this;
    }
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }
    public RegistrationPage setState(String state) {
        stateInput.scrollTo().click();
        stateAndCityWrapper.$(byText(state)).click();
        return this;
    }
    public RegistrationPage setCity(String city) {
        cityInput.scrollTo().click();
        stateAndCityWrapper.$(byText(city)).click();
        return this;
    }
    public void confirmForm() {
        submitButton.click();
    }
    public RegistrationPage checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }




}
