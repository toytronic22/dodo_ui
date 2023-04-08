package ru.dodopizza.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.dodopizza.pages.HalvesPage;

import static io.qameta.allure.Allure.step;

@Owner("toytronic")
@Feature("UI тесты dodopizza.ru")
@Story("Проверка сборки половинок. Работает только если работает пиццерия")
@Tags({@Tag("products")})

public class HalvesPageTest extends TestBase {
    HalvesPage halvesPage = new HalvesPage();

    @Test
    @DisplayName("Check Halves Works")
    public void addToCartTest() {
        step("Открытие страницы продукта", () -> {
            halvesPage.openHalvesCard();
        });
        step("Собираем пиццу из половинок", () -> {
            halvesPage.connectHalves();
        });
        step("Добавление продукта в корзину", () -> {
            halvesPage.addToCart();
        });
        step("Проверка названия продукта в корзине", () -> {
            halvesPage.checkAddedProductTitle();
        });
    }
}
