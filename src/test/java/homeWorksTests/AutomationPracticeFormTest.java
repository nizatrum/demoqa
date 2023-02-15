package homeWorksTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
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
        $(byText(birthMonth)).click();
        $("select[class*='year']").click();
        $(String.format("option[value='%s']", birthYear)).click();
        $(String.format("div[class*='day--0%s']", birthDay)).click();
        //заполняем предметы
        for (String subject : subjects) {
            $("#subjectsInput").setValue(subject);
            $x(String.format("//div[text()='%s' and @tabindex]", subject)).click();
        }
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
        executeJavaScript("$('footer').hide()");
        executeJavaScript("$('#close-fixedban').parent().hide();");
        $("#submit").click(); // кликаем кнопку утверждения формы
        // asserts
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
