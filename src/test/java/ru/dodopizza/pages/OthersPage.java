package ru.dodopizza.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class OthersPage {
    private final SelenideElement booksLink = $(byCssSelector(".sc-1tpn8pe-3:nth-child(2) .loaded"));
    private final SelenideElement drawBookLink = $(byLinkText("Додо Раскраска"));
    private final SelenideElement beakLink = $(byLinkText("Додо Клюв"));
    private final SelenideElement capLink = $(byLinkText("Додо Колпак"));

    public void  open() {
        com.codeborne.selenide.Selenide.open("https://dodopizza.ru/moscow#other");
    }

    public void checkProducts() {
        booksLink.shouldBe(Condition.visible);
        drawBookLink.shouldBe(Condition.visible);
        beakLink.shouldBe(Condition.visible);
        capLink.shouldBe(Condition.visible);
    }
}