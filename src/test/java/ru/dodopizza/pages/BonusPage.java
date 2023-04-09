package ru.dodopizza.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BonusPage {
    private final SelenideElement coffeeBonus = $(byText("Поворотный момент"));
    private final SelenideElement jobInfo = $(byText("Работа в Додо!"));
    private final SelenideElement cashbackInfo = $(byText("Ну всё, кешбэк!"));
    private final SelenideElement receiptInfo = $(byText("Получайте чеки онлайн"));

    public void  open() {
        com.codeborne.selenide.Selenide.open("https://dodopizza.ru/moscow/bonusactions");
    }

    public void checkProducts() {
        coffeeBonus.shouldBe(Condition.visible);
        jobInfo.shouldBe(Condition.visible);
        cashbackInfo.shouldBe(Condition.visible);
        receiptInfo.shouldBe(Condition.visible);
    }
}