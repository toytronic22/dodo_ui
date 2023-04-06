package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProductPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("Alexey Martynov")
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории")
@Link(value = "Тест dodo_ui", url = "https://github.com/toytronic22/dodo_ui")

public class ProductPageTest extends TestBase2 {
    ProductPage productPage = new ProductPage();

    @Test
    @DisplayName("Check Adding Exact Product to Cart")
    public void addToCartTest() {
        step("Открытие страницы - https://dodopizza.ru/moscow", () -> {
            open(baseUrl);
        });
        step("Добавление продукта в корзину", () -> {
            productPage.addToCart();
        });
        step("Проверка добавляемого продукта", () -> {
            productPage.checkProductTitleExists();
        });
        step("Проверка названия продукта в корзине", () -> {
            productPage.checkAddedProductTitle();
        });
    }
}
