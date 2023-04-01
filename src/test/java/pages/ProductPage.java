package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class ProductPage {

    private SelenideElement productTitle = $(byTagAndText("h1", "Сырная"));
    private SelenideElement addButton = $(byClassName("sc-8hteo7-21"));
    private SelenideElement cartButton = $(byClassName("xlo7eb-9"));
    private SelenideElement addedProductTitle = $(byClassName("qt41kr-5"));

    public void checkProductTitleExists() {
        productTitle.should(exist);
    }

    public void addToCart() {
        addButton.click();
        cartButton.click();
    }

    public void checkAddedProductTitle(String expectedTitle) {
        addedProductTitle.shouldHave(text(expectedTitle));
    }
}
