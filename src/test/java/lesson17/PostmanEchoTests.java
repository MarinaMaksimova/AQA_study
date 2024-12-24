package lesson17;

/*Перейдите в сервис Postman. Войдите в свой аккаунт и скачайте себе коллекцию Postman Echo.
Написать автотесты для каждого метода из папки Request Methods (проверка тела ответа (просто
сравнить значения всех полей) и кода ответа).*/

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void getRequestTest() {

        given()
                .contentType("application/json")
        .when()
                .get("/get/?foo1=bar1&foo2=bar2")
        .then().log().body()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/get/?foo1=bar1&foo2=bar2"))
         .statusCode(200);
    }

    @Test
    public void postRawTextTest() {

        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .post("/post")
         .then().log().body()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
//                .body("headers.content-type", equalTo("text/plain"))    // проверить
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                //.body("headers.postman-token", equalTo(null))
                //.body("headers.accept-encoding", equalTo("gzip,deflate"))
                //.body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"))
         .statusCode(200);
    }

    @Test
    public void postFromDataTest() {

        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
        .when()
                .post("/post")
        .then().log().body()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo(""))
                .body("files", equalTo(Map.of()))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"))
        .statusCode(200);
    }

    @Test
    public void putTest() {

        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .put("/put")
        .then().log().body()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
//                .body("headers.content-type", equalTo("text/plain"))    // проверить
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                //.body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                //.body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"))
        .statusCode(200);
    }

    @Test
    public void patchTest() {

        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .patch("/patch")
        .then().log().body()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
//                .body("headers.content-type", equalTo("text/plain"))    // проверить
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                //.body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                //.body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"))
        .statusCode(200);
    }

    @Test
    public void deleteTest() {

        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
        .when()
                .delete("/delete")
        .then().log().body()
                .body("args", equalTo(Map.of()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Map.of()))
                .body("form", equalTo(Map.of()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
//                .body("headers.content-type", equalTo("text/plain"))    // проверить
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                //.body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                //.body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete"))
        .statusCode(200);
    }

}
