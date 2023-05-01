package ru.dodopizza.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HalvesPage {
    private final SelenideElement addButton = $(byXpath("//span[contains(.,'Добавить в корзину за 820 ₽')]"));
    private final SelenideElement cartButton = $(byCssSelector(".xlo7eb-10"));
    private final SelenideElement addedProductTitle = $(byTagAndText("h3", "Ветчина и сыр + Аррива!"));

    public void openHalvesCard() {
        open("https://dodopizza.ru/moscow/pizza/halfs");
    }

    public void connectHalves() {
        $(byCssSelector(".sc-10cr63z-2:nth-child(2)")).click();
        $(byCssSelector(".sc-10cr63z-2:nth-child(3)")).click();
    }

    public void addToCart() {
        addButton.click();
        $(byXpath("//button[contains(.,'Забрать из пиццерии')]")).click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(byCssSelector(".submit-button")).click();
        cartButton.click();
    }

    public void checkAddedProductTitle() {
        addedProductTitle.should(exist);
    }
}
