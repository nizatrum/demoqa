package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;



public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
    }
    @BeforeEach
    void beforeEach() {
        Selenide.open("/automation-practice-form");
        RegistrationPage.removeInterceptingButtonElements();
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }

    @Test
    void test() {
        Assertions.assertTrue(true);
    }
}
