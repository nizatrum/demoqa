package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
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
    //actions
    public void removeInterceptingButtonElements() {
        executeJavaScript("$('footer').hide()");
        executeJavaScript("$('#close-fixedban').parent().hide();");
    }
    public void openRegistrationForm(String url) {
        open(url);
    }
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }
    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }
    public void setEmail(String email) {
        emailInput.setValue(email);
    }
    public void setGender(String gender) {
        genderInput.$(byText(gender)).click();
    }
    public void setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
    }
    public void setDateOfBirth(String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.datePadding(month, year);
    }
    public void setSubjects(String[] subjects) {
        for (String subject : subjects)
            subjectsInput.setValue(subject).pressEnter();
    }
    public void setHobbies(String[] hobbies) {
        for (String hobby : hobbies)
            hobbiesInput.$(byText(hobby)).click();
    }
    public void uploadPicture(File picture) {
        pictureLoading.uploadFile(picture);
    }
    public void setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
    }
    public void setState(String state) {
        stateInput.scrollTo().click();
        stateAndCityWrapper.$(byText(state)).click();
    }
    public void setCity(String city) {
        cityInput.scrollTo().click();
        stateAndCityWrapper.$(byText(city)).click();
    }
    public void confirmForm() {
        submitButton.click();
    }




}
