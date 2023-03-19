package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class HomePageTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://dodopizza.ru/moscow";
    }

    @Test
    public void checkTitle() {
        open("/");
        $("title").shouldBe(visible).shouldHave(
                com.codeborne.selenide.conditions.Text.text("Dodo Pizza – доставка пиццы на дом и в офис в Москве и Санкт-Петербурге"));
    }
}