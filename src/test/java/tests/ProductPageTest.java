package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPageTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://dodopizza.ru/moscow";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "200.0");
        Configuration.remote = System.getProperty("remote");
        Configuration.timeout = 30000;
    }

    @Test
    public void addToCartTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/pizza/syrnaya-pizza");
        $(byTagAndText("h1", "Сырная")).should(exist);
        $(byClassName("sc-8hteo7-21")).click();
        $(byClassName("xlo7eb-9")).click();
        $(byClassName("qt41kr-5")).shouldHave(text("Сырная"));
    }
}
