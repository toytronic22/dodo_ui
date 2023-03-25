package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePageTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://dodopizza.ru/moscow";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "200.0");
        Configuration.remote = System.getProperty("remote");
    }

    @Test
    public void openPage() {
        open("/");
        $(".header__about-slogan-text_locality").shouldHave(text("Москва"));
    }

    @Test
    public void checkMainMenu() {
        open("/");
        $(byLinkText("Пицца")).shouldBe(visible);
        $(byLinkText("Комбо")).shouldBe(visible);
        $(byLinkText("Напитки")).shouldBe(visible);
        $(byLinkText("Другие товары")).shouldBe(visible);
        $(byLinkText("Акции")).shouldBe(visible);
        $(byLinkText("Контакты")).shouldBe(visible);
        $(byLinkText("О нас")).shouldBe(visible);
        $(byLinkText("Работа в Додо")).shouldBe(visible);
    }
}