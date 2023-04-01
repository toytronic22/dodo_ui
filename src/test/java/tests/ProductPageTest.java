package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ProductPageTest extends TestBase {

    @Test
    @Tag(value = "dodo")
    @DisplayName("Check Localization and Main Menu")
    public void addToCartTest() {
        step("Открытие страницы продукта", () -> {
            ProductPage productPage = open("/pizza/syrnaya-pizza", ProductPage.class);
        });
        ProductPage productPage = new ProductPage();
        productPage.checkProductTitleExists();
        productPage.addToCart();
        productPage.checkAddedProductTitle("Сырная");
    }
}
