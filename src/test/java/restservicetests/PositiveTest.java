package restservicetests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class PositiveTest {
    @Test
    public void postUser() {
        String request = "{\n" +
                "   \"email\": \"eve.holt@reqres.in\",\n" +
                "   \"password\": \"pistol\"\n" +
                "}";

        RestAssured
                .given()
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .post("https://reqres.in/api/register")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("id", equalTo(4),
                        "token", equalTo("QpwL5tke4Pnpja7X4"));

    }
    @Test
    public void putUser() {
        String update = "{\n" +
                "   \"name\": \"morpheus\",\n" +
                "   \"job\": \"zion resident\"\n" +
                "}";
        RestAssured
                .given()
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .body(update)
                    .put("https://reqres.in/api/users/2")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("name", equalTo("morpheus"),
                        "job", equalTo("zion resident"));
    }
    @Test
    public void deleteUser() {
        RestAssured
                .given()
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .delete("https://reqres.in/api/users/2")
                .then()
                    .log().all()
                    .statusCode(204)
                    .body(isEmptyString());
    }
    @Test
    public void getUser() {
        RestAssured
                .given()
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .get("https://reqres.in/api/users/4")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("data.id", equalTo(4),
                            "data.email", equalTo("eve.holt@reqres.in"),
                            "data.first_name", equalTo("Eve"),
                            "data.last_name", equalTo("Holt"),
                            "data.avatar", equalTo("https://reqres.in/img/faces/4-image.jpg"),
                            "support.url", equalTo("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral"),
                            "support.text", equalTo("Tired of writing endless social media content? Let Content Caddy generate it for you."));
    }
}


