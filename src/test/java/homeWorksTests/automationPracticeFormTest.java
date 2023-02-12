package homeWorksTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selenide.*;

public class automationPracticeFormTest extends DataForAutomationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = WINDOW_SIZE;
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("[placeholder='First Name']").setValue(firstName);
        $("[placeholder='Last Name']").setValue(lastName);
        $("[placeholder='name@example.com']").setValue(email);
        $(String.format("div.custom-radio input[value='%s'] +label", gender)).click();
        $("[placeholder='Mobile Number']").setValue(phoneNumber);
        $("[placeholder=First Name]").setValue(firstName);
        actions().click($("#dateOfBirthInput")).
                click($("select[class*='month']")).
                click($("select[class*='month']")). // как выбрать ебучий текст по css хуяторам!"?"?"?"?""?!!!
                click($("select[class*='month']")).
                build().perform();


    }
}
