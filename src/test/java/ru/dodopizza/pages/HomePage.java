package ru.dodopizza.pages;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;

public class HomePage {

    private final String localityCssSelector = ".header__about-slogan-text_locality";

    public void open() {
        com.codeborne.selenide.Selenide.open("/");
    }

    public void verifyLocation(String cityName) {
        $(byCssSelector(".header__about-slogan-text_locality")).shouldHave(text(cityName));
    }
}