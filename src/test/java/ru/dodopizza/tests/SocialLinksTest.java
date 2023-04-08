package ru.dodopizza.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.dodopizza.pages.SocialLinksPage;

import static io.qameta.allure.Allure.step;

@Owner("toytronic")
@Feature("UI тесты dodopizza.ru")
@Story("Проверка ссылок на социальные сети")
@Tags({@Tag("ui")})

public class SocialLinksTest extends TestBase {
    SocialLinksPage socialLinksPage = new SocialLinksPage();

    @Test
    @DisplayName("Check Social Links are Interactable")
    public void socialLinksTest() {
        step("Открытие главной страницы", () -> {
            socialLinksPage.openMainPage();
        });
        step("Проверяем одноклассники", () -> {
            socialLinksPage.checkOk();
        });
        step("Проверяем Вконтакте", () -> {
            socialLinksPage.checkVk();
        });
        step("Проверяем YouTube", () -> {
            socialLinksPage.checkYouTube();
        });
    }
}
