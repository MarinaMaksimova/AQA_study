package lesson17;

/*Перейдите в сервис Postman. Войдите в свой аккаунт и скачайте себе коллекцию Postman Echo.
Написать автотесты для каждого метода из папки Request Methods (проверка тела ответа (просто
сравнить значения всех полей) и кода ответа).*/

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;             // Статический импорт позволит использовать методы без указания имени класса RestAssured
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    static String url = "https://postman-echo.com";
    static String acceptEncoding = "gzip, deflate, br";
    static String host = "postman-echo.com";
    static String connection = "close";
    static String xForwardedProto = "https";
    static String xForwardedPort = "443";

    @BeforeAll                                          // Настройка базовой конфигурации RestAssured
    public static void configureRestAssured() {
        baseURI = url;
        requestSpecification = given()
                .header("accept-encoding", acceptEncoding);
    }

    @Test                                               // Тест GET-запроса из Postman Echo
    @DisplayName("Тест GET-запроса из Postman Echo")
    public void getRequestTest() {
        given()
                .contentType("application/json")
        .when()
                .get("/get?foo1=bar1&foo2=bar2")
        .then().log().body().assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo(host))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo(connection))
                .body("headers.x-forwarded-proto", equalTo(xForwardedProto))
                .body("headers.x-forwarded-port", equalTo(xForwardedPort))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo(acceptEncoding))
                .body("headers.cookie", equalTo(null))
                .body("url", equalTo(url + "/get?foo1=bar1&foo2=bar2"))
        .statusCode(200);
    }

    @Test                                               // Тест POST-запроса Raw Text из Postman Echo
    @DisplayName("Тест POST-запроса Raw Text из Postman Echo")
    public void postRawTextTest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .post("/post")
        .then().log().body().assertThat()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo(host))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo(connection))
                .body("headers.x-forwarded-proto", equalTo(xForwardedProto))
                .body("headers.x-forwarded-port", equalTo(xForwardedPort))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo(acceptEncoding))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo(url + "/post"))
        .statusCode(200);
    }

    @Test                                               // Тест POST-запроса From Data из Postman Echo
    @DisplayName("Тест POST-запроса From Data из Postman Echo")
    public void postFromDataTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
        .when()
                .post("/post")
        .then().log().body().assertThat()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo(""))
                .body("files", equalTo(Map.of()))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo(host))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo(connection))
                .body("headers.x-forwarded-proto", equalTo(xForwardedProto))
                .body("headers.x-forwarded-port", equalTo(xForwardedPort))
                .body("headers.content-length", equalTo("19"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo(acceptEncoding))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo(url + "/post"))
        .statusCode(200);
    }

    @Test                                               // Тест PUT-запроса из Postman Echo
    @DisplayName("Тест PUT-запроса из Postman Echo")
    public void putTest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .put("/put")
        .then().log().body().assertThat()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo(host))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo(connection))
                .body("headers.x-forwarded-proto", equalTo(xForwardedProto))
                .body("headers.x-forwarded-port", equalTo(xForwardedPort))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo(acceptEncoding))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo(url + "/put"))
        .statusCode(200);
    }

    @Test                                               // Тест PATCH-запроса из Postman Echo
    @DisplayName("Тест PATCH-запроса из Postman Echo")
    public void patchTest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .patch("/patch")
        .then().log().body().assertThat()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo(host))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo(connection))
                .body("headers.x-forwarded-proto", equalTo(xForwardedProto))
                .body("headers.x-forwarded-port", equalTo(xForwardedPort))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo(acceptEncoding))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo(url + "/patch"))
        .statusCode(200);
    }

    @Test                                               // Тест DELETE-запроса из Postman Echo
    @DisplayName("Тест DELETE-запроса из Postman Echo")
    public void deleteTest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .delete("/delete")
        .then().log().body().assertThat()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo(host))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo(connection))
                .body("headers.x-forwarded-proto", equalTo(xForwardedProto))
                .body("headers.x-forwarded-port", equalTo(xForwardedPort))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo(acceptEncoding))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo(url + "/delete"))
        .statusCode(200);
    }
}
