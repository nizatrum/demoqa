package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.text.MessageFormat;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static tests.RegistrationFormTests.*;

public class CalendarComponent {
    // base variables for base date field
    SelenideElement monthInput = $(".react-datepicker__month-select");
    SelenideElement yearInput = $(".react-datepicker__year-select");
    SelenideElement dayInput = monthInput.$(".react-datepicker__month > div > div").$(byText(birthDay));

    public void datePadding(String month ,String year) {
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.click();
    }
}
