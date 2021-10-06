package tests;

import allure.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Layer("web")
@Lead("qa-lead")
@Feature("Tests for 'It-one'")
public class WebTests extends TestBase {
    @Test
    @Owner("antonina")
    @Story("Проверка заголовка главной страницы")
    @Microservice("Repository")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Проверка свойства title главной страницы")
    void titleTest() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Свойство title главной страницы сайта должно быть равно IT_ONE. Разработка программного обеспечения мирового уровня'", () -> {
            String expectedTitle = "IT_ONE. Разработка программного обеспечения мирового уровня";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Owner("antonina")
    @Story("Открытие страниц сайта")
    @Microservice("Billing")
    @Tags({@Tag("web"), @Tag("smoke")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Переход на страницу 'Услуги'")
    void checkOpenPageUslugi() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Клик по кнопке 'Услуги'", () -> {
            $(".main-intro__slide-button_1").click();
        });

        step("Свойство title открытой страницы сайта должно быть равно 'Услуги IT_ONE'", () -> {
            String expectedTitle = "Услуги IT_ONE";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Owner("antonina")
    @Story("Открытие страниц сайта")
    @Microservice("Billing")
    @Tags({@Tag("web"), @Tag("smoke")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Переход на страницу 'Карьера'")
    void checkOpenPageCareer() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Переключение на третий слайдер", () -> {
            $(".main-intro__switch_3").click();
        });

        step("Клик по кнопке 'Карьера'", () -> {
            $(".main-intro__slide-button_3").click();
        });

        step("Свойство title открытой страницы сайта должно быть равно 'Карьера в IT_ONE'", () -> {
            String expectedTitle = "Карьера в IT_ONE";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Owner("antonina")
    @Story("Открытие страниц сайта")
    @Microservice("Billing")
    @Tags({@Tag("web"), @Tag("smoke")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Переход на страницу 'Компания'")
    void checkOpenPageCompany() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Клик по ссылке 'Компания'", () -> {
            $(By.linkText("Компания")).click();
        });

        step("Свойство title открытой страницы сайта должно быть равно 'Компания'", () -> {
            String expectedTitle = "Компания";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });


    }

    @Test
    @Owner("antonina")
    @Story("Открытие страниц сайта")
    @Microservice("Repository")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Переход на страницу 'Вакансии'")
    void checkOpenPageVacancies() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Клик по кнопке 'Все вакансии'", () -> {
            $(byId("job-section")).$(".common-button").click();
        });

        step("Свойство title открытой страницы сайта должно быть равно 'Вакансии'", () -> {
            String expectedTitle = "Вакансии";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }


}
