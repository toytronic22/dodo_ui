package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ProductPage;

public class TestProductPage {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://dodopizza.ru/moscow";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "200.0");
        Configuration.remote = System.getProperty("remote");
        Configuration.timeout = 20000;
    }

    @Test
    public void addToCartTest() {
        ProductPage productPage = new ProductPage();
        productPage.openPage();
        productPage.checkProductName();
        productPage.addToCart();
        productPage.goToCart();
        productPage.checkCartProduct();
    }
}
