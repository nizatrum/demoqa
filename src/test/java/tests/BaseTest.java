package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;



public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "http://10.155.56.61:4444/wd/hub/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.remote = "http://10.155.56.61:4444/wd/hub/";
        Configuration.browserCapabilities = capabilities;
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
