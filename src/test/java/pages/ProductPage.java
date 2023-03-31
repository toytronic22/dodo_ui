package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    private SelenideElement productName = $(byTagAndText("h1", "Сырная"));
    private SelenideElement addToCartButton = $(byClassName("sc-8hteo7-21"));
    private SelenideElement goToCartButton = $(byClassName("xlo7eb-9"));
    private SelenideElement cartProduct = $(byClassName("qt41kr-5"));

    public void openPage() {
        open("/pizza/syrnaya-pizza");
    }

    public void checkProductName() {
        productName.should(exist);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        goToCartButton.click();
    }

    public void checkCartProduct() {
        cartProduct.shouldHave(text("Сырная"));
    }
}