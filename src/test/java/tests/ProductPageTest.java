package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import static io.qameta.allure.Allure.step;

public class ProductPageTest extends TestBase {
    ProductPage productPage = new ProductPage();

    @Test
    @Tag(value = "dodo")
    @DisplayName("Check Adding Exact Product to Cart")
    public void addToCartTest() {
        step("Открытие страницы продукта", () -> {
            productPage.openProductPage();
        });
        step("Проверка названия продукта", () -> {
            productPage.checkProductTitleExists();
        });
        step("Добавление продукта в корзину", () -> {
            productPage.addToCart();
        });
        step("Проверка названия продукта в корзине", () -> {
            productPage.checkAddedProductTitle();
        });
    }
}
