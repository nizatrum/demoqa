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
        //заполняем дату рождения
        $("#dateOfBirthInput").click();
        $("select[class*='month']").click();
        $(byText(birthMonth)).click(); //а если я не найду, мне надо уточнить из какого родительского элемента мы ищем внутрь, либо кто родитель.
        $("select[class*='year']").click();
        $(String.format("option[value='%s']", birthYear)).click();
        $(String.format("div[class*='day--0%s']", birthDay)).click();
        $("#subjectsInput").setValue(subjects); //заполняем какие-то ярлыки :D
        //заполняем увлечения
        for (String hobby : hobbies) {
            $(byText(hobby)).click();
        }
        $("#uploadPicture").uploadFile(picture); // грузим фотку
        $("#currentAddress").setValue(currentAddress); //заполняем фактический адрес
        $("#state").scrollTo().click();
        // заполняем state and city
        $(byText(state)).click();
        $("#city").scrollTo().click();
        $(byText(city)).click();
        // убираем лишние элементы, не позволяющие кликнуть submit
        Selenide.executeJavaScript("$('footer').hide()");
        Selenide.executeJavaScript("$('#close-fixedban').parent().hide();");
        $("#submit").scrollIntoView(false).click(); // кликаем кнопку утверждения формы



    }
    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
