package ru.dodopizza.pages;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SocialLinksPage {
    public void openMainPage() {

        open("https://dodopizza.ru/moscow");
    }
    public void checkOk() {

        $(By.cssSelector(".odnoklassniki svg")).shouldBe(interactable);
    }
    public void checkVk() {

        $(By.cssSelector(".vkontakte path")).shouldBe(interactable);
    }
    public void checkYouTube() {

        $(By.cssSelector(".youtube path")).shouldBe(interactable);
    }
}