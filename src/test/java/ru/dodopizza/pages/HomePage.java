package ru.dodopizza.pages;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public void open() {
       com.codeborne.selenide.Selenide.open("/");
    }
    public void getLocalityTitle(){
        $(byCssSelector(".header__about-slogan-text_locality")).shouldHave(text("Москва"));
    }
}