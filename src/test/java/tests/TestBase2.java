package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import web.drivers.DriverSettings;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase2 {
    static WebConfig config = ConfigFactory.create(WebConfig.class);
    static String useRemote = System.getProperty("webPlatform", "local");

    @BeforeAll
    static void firstSetup() {
        DriverSettings.configuration();
        if (useRemote.equals("remote")) {
            Configuration.remote = config.remoteUrl();
        }
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (useRemote.equals("remote")) {
            Attach.addVideo();
        }
        closeWebDriver();
    }



}