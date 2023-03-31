package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.System.getProperty;

public class HomePage {

    private SelenideElement localityTitle = $(".header__about-slogan-text_locality");

    // локаторы для главного меню
    private SelenideElement pizzaLink = $(byLinkText("Пицца"));
    private SelenideElement comboLink = $(byLinkText("Комбо"));
    private SelenideElement drinksLink = $(byLinkText("Напитки"));
    private SelenideElement otherProductsLink = $(byLinkText("Другие товары"));
    private SelenideElement promotionsLink = $(byLinkText("Акции"));
    private SelenideElement contactsLink = $(byLinkText("Контакты"));
    private SelenideElement aboutUsLink = $(byLinkText("О нас"));
    private SelenideElement careersLink = $(byLinkText("Работа в Додо"));

    public HomePage open() {
        String baseUrl = "https://dodopizza.ru/moscow";
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "200.0";
        Configuration.remote = getProperty("remote");
        Configuration.timeout = 30000;
        com.codeborne.selenide.Selenide.open("/");
        return this;
    }

    public String getLocalityTitle() {
        return localityTitle.getText();
    }

    public void checkMainMenu() {
        pizzaLink.shouldBe(Condition.visible);
        comboLink.shouldBe(Condition.visible);
        drinksLink.shouldBe(Condition.visible);
        otherProductsLink.shouldBe(Condition.visible);
        promotionsLink.shouldBe(Condition.visible);
        contactsLink.shouldBe(Condition.visible);
        aboutUsLink.shouldBe(Condition.visible);
        careersLink.shouldBe(Condition.visible);
    }
}
