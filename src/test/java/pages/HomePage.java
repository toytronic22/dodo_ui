package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class HomePage {
    private final SelenideElement localityTitle = $(".header__about-slogan-text_locality");
    private final SelenideElement pizzaLink = $(byLinkText("Пицца"));
    private final SelenideElement comboLink = $(byLinkText("Комбо"));
    private final SelenideElement drinksLink = $(byLinkText("Напитки"));
    private final SelenideElement otherProductsLink = $(byLinkText("Другие товары"));
    private final SelenideElement promotionsLink = $(byLinkText("Акции"));
    private final SelenideElement contactsLink = $(byLinkText("Контакты"));
    private final SelenideElement aboutUsLink = $(byLinkText("О нас"));
    private final SelenideElement careersLink = $(byLinkText("Работа в Додо"));

    public HomePage open(String baseUrl) {
       com.codeborne.selenide.Selenide.open("");
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