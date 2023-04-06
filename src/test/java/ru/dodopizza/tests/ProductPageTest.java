package ru.dodopizza.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.dodopizza.pages.ProductPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("toytronic")
@Feature("UI тесты dodopizza.ru")
@Story("Главная страница dodopizza.ru")
@Tags({@Tag("ui")})

public class ProductPageTest extends TestBase {
    ProductPage productPage = new ProductPage();

    @Test
    @DisplayName("Check Adding Exact Product to Cart")
    public void addToCartTest() {
        step("Открытие страницы продукта", () -> {
            productPage.openProductCard();
        });
        step("Добавление продукта в корзину", () -> {
            productPage.addToCart();
        });
        step("Проверка названия продукта в корзине", () -> {
            productPage.checkAddedProductTitle();
        });
    }
}
