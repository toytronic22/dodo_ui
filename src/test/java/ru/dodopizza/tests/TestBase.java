package ru.dodopizza.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.dodopizza.config.ConfigReader;
import ru.dodopizza.config.ProjectConfiguration;
import ru.dodopizza.config.web.WebConfig;
import ru.dodopizza.helpers.Attach;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestBase {
    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @BeforeAll
    public static void configure() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
        Configuration.baseUrl = "https://dodopizza.ru/moscow";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    public void setUp() {
        step("Открываем сайт", () -> {
            open("");
        });
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();

    }
}
