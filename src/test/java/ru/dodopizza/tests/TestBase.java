package ru.dodopizza.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
    }

    @BeforeEach
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
