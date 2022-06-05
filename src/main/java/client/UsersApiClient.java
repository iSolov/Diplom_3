package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.AuthorizationInfo;
import models.User;
import org.apache.http.HttpStatus;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * API для работы с пользователями.
 */
public class UsersApiClient {
    public static final String API_URL = "https://stellarburgers.nomoreparties.site/api/";

    /**
     * Токены созданных пользователей для дальнейшей очистки.
     */
    private final ArrayList<String> usersTokensForDelete = new ArrayList<>();

    /**
     * Настройка выполнения запросов.
     */
    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(API_URL)
                .build();
    }

    /**
     * Создание нового пользователя.
     */
    public Response register(User user) {
        return given()
                .spec(getRequestSpecification())
                .body(user.toJson())
                .when()
                .post(API_URL + "auth/register");
    }

    /**
     * Авторизация пользователя.
     */
    public void login(User user) {
        AuthorizationInfo authorizationInfo = given()
                .spec(getRequestSpecification())
                .body(user.toJson())
                .when()
                .post(API_URL + "auth/login")
                .as(AuthorizationInfo.class);

        usersTokensForDelete.add(authorizationInfo.getAccessToken());
    }

    /**
     * Удаляет всех созданных пользователей.
     */
    public void deleteCreatedUsers() {
        usersTokensForDelete.forEach(this::delete);
    }

    /**
     * Удаляет пользователя по токену.
     */
    public void delete(String token) {
        given()
                .spec(getRequestSpecification())
                .auth().oauth2(token)
                .when()
                .delete("auth/user")
                .then()
                .statusCode(HttpStatus.SC_ACCEPTED);
    }
}
