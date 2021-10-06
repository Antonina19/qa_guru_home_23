package tests;

import allure.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

@Layer("rest")
@Lead("qa-lead")
@Owner("puliavinaav")
@Feature("User")
public class ApiTests {
    @Test
    @Story("Создание нового пользователя")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("regress")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Создание нового пользователя с именем 'user11' ")
    void usersCreate() {
        given()
                .contentType(JSON)
                .body("{\n" +
                        "    \"name\": \"user11\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", is("user11"))
                .body("job", is("leader"));
    }

    @Test
    @Story("Проверка данных пользователя")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("regress")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Проверка emal и имени пользователя")
    void usersGet() {
        given()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.email", is("janet.weaver@reqres.in"))
                .body("data.first_name", is("Janet"));
    }

    @Test
    @Story("Получение списка пользователей")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("regress")})
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Получение списка пользователей со страницы 1")
    void usersListGet() {
        given()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .statusCode(200)
                .body("page", is(1))
                .body("per_page", is(6))
                .body("total", is(12));
    }

    @Test
    @Story("Поиск текста")
    @Microservice("Repository")
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Поиск текста на странице 3")
    void usersListGetFindText() {
        given()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users?page=3")
                .then()
                .statusCode(200)
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }

    @Test
    @Story("Удаление пользователя")
    @Microservice("Billing")
    @Tag("api")
    @JiraIssues({@JiraIssue("HOMEWORK-238")})
    @DisplayName("Удаление пользователя под номером 5")
    void usersDelete() {
        given()
                .when()
                .delete("https://reqres.in/api/users/5")
                .then()
                .statusCode(204);
    }
}
