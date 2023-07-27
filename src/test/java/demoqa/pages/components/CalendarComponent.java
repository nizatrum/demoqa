package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    // base variables for base date field
    SelenideElement monthInput = $(".react-datepicker__month-select");
    SelenideElement yearInput = $(".react-datepicker__year-select");
    public void datePadding(String day, String month ,String year) {
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        chooseDate(day).click();
    }

    public SelenideElement chooseDate(String day) {
        return $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)");
    }
}
