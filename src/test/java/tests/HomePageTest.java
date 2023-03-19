package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePageTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://dodopizza.ru/moscow";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.remote = System.getProperty("remote");
    }

    @Test
    public void openPage() {
        open("https://dodopizza.ru/moscow");
    }

    public void verifyLocality() {
        $(byClassName("header__about-slogan-text_locality")).shouldHave(text("Москва"));
    }
}