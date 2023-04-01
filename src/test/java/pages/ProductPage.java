package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement productTitle = $(byTagAndText("h1", "Сырная"));
    private final SelenideElement addButton = $(byClassName("sc-8hteo7-21"));
    private final SelenideElement cartButton = $(byClassName("xlo7eb-9"));
    private final SelenideElement addedProductTitle = $(byTagAndText("h3", "Сырная пицца"));
    public void open() {
        Selenide.open("https://dodopizza.ru/moscow/pizza/syrnaya-pizza");
    }
    public void checkProductTitleExists() {
        productTitle.should(exist);
    }
    public void addToCart() {
        addButton.click();
        cartButton.click();
    }
    public void checkAddedProductTitle() {
        addedProductTitle.should(exist);
    }
}
