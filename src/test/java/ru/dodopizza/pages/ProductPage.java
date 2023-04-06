package ru.dodopizza.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPage {
    private final SelenideElement productTitle = $(byTagAndText("h1", "Сырная"));
    private final SelenideElement addButton = $(byClassName("sc-8hteo7-21"));

    private final SelenideElement cartButton = $(byClassName("xlo7eb-9"));
    private final SelenideElement addedProductTitle = $(byTagAndText("h3","Сырная"));

    public void openProductCard() {
        open("https://dodopizza.ru/moscow/pizza/syrnaya-pizza");
    }
    public void addToCart() {
        addButton.click();
        $(byXpath("//button[contains(.,'Забрать из пиццерии')]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(byCssSelector(".submit-button")).click();
        cartButton.click();
    }
    public void checkAddedProductTitle() {
        addedProductTitle.should(exist);
    }
}
