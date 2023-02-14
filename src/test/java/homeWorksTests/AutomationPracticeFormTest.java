package homeWorksTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest extends DataForAutomationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = WINDOW_SIZE;
    }
    @Test
    @DisplayName("Заполняем форму данными из DataForAutomationPracticeForm")
    void fillFormTest() {
        open("/automation-practice-form"); //открываем
        $("#firstName").setValue(firstName); //заполняем имя
        $("#lastName").setValue(lastName); //заполняем фамилию
        $("#userEmail").setValue(email); //заполняем почту
        $(String.format("div.custom-radio input[value='%s'] +label", gender)).click(); //заполняем пол
        $("#userNumber").setValue(phoneNumber); //заполняем номер телефона
        fillBirthDate(birthDay, birthMonth, birthYear); //заполняем дату рождения
        $("#subjectsInput").setValue(subjects); //заполняем какие-то ярлыки :D
        fillHobbies(hobbies); //заполняем увлечения
        $("#uploadPicture").uploadFile(picture); // грузим фотку
        $("#currentAddress").setValue(currentAddress); //заполняем фактический адрес
        $("#state").scrollTo().click();
        $(byText(state)).click();
        $("#city").scrollTo().click();
        $(byText(city)).click();
        $("#submit").scrollTo().click();// ???????


    }
    private void fillBirthDate(byte day, String month, short year) {
        $("#dateOfBirthInput").click();
        $("select[class*='month']").click();
        $(byText(month)).click(); //а если я не найду, мне надо уточнить из какого родительского элемента мы ищем внутрь, либо кто родитель.
        $("select[class*='year']").click();
        $(String.format("option[value='%s']", year)).click();
        $(String.format("div[class*='day--0%s']", day)).click();
    }
    private void fillHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            $(byText(hobby)).click();
        }
    }
    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
