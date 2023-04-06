package ru.dodopizza.tests;

import ru.dodopizza.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
//import config.CredentialsConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
//    private static final CredentialsConfig configs = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setUp() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        Configuration.baseUrl = "https://dodopizza.ru/moscow";
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserSize = System.getProperty("browsersize");
//        Configuration.remote = "https://" + configs.selenoidLogin() + ":" + configs.selenoidPass() + "@" + System.getProperty("selenoid_server");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
//        Configuration.pageLoadTimeout = 40000;

    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}