package ru.dodopizza.pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class MenuPage {
    private enum MenuItems {
        PIZZA("Пицца"),
        COMBO("Комбо"),
        DRINKS("Напитки"),
        OTHER_PRODUCTS("Другие товары"),
        PROMOTIONS("Акции"),
        CONTACTS("Контакты"),
        ABOUT_US("О нас"),
        CAREERS("Работа в Додо");

        private final String linkText;

        MenuItems(String linkText) {
            this.linkText = linkText;
        }

        public String getLinkText() {
            return linkText;
        }
    }

    public void open() {
        com.codeborne.selenide.Selenide.open("/");
    }

    public void checkMainMenu() {
        for (MenuItems item : MenuItems.values()) {
            $(byLinkText(item.getLinkText())).shouldBe(Condition.visible);
        }
    }
}
