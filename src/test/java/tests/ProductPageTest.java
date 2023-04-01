package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProductPage;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
public class ProductPageTest extends TestBase {

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://dodopizza.ru/moscow";
        browserSize = System.getProperty("browserSize", "1920x1080");
        browser = System.getProperty("browser", "chrome");
        browserVersion = System.getProperty("browserVersion", "200.0");
        remote = System.getProperty("remote");
        timeout = 30000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @Tag(value = "dodo")
    @DisplayName("Check Localization and Main Menu")
    public void addToCartTest() {
        ProductPage productPage = open("/pizza/syrnaya-pizza", ProductPage.class);
        productPage.checkProductTitleExists();
        productPage.addToCart();
        productPage.checkAddedProductTitle("Сырная");
    }
}
