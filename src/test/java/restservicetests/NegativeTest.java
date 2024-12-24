package restservicetests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class NegativeTest {
    @Test
    public void postUser() {
        String request = "{\n" +
                "   \"email\": \"Antoshka\",\n" +
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
                    .statusCode(400)
                    .body("error", equalTo("Note: Only defined users succeed registration"));

    }
    @Test
    public void putUser() {
        String update = "{\n" +
                "   \"name\": \"\",\n" +
                "   \"job\": \"\"\n" +
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
                    .body("name", equalTo(""),
                        "job", equalTo(""));
    }
    @Test
    public void deleteUser() {
        RestAssured
                .given()
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .delete("https://reqres.in/api/users/0")
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
                    .get("https://reqres.in/api/users/0")
                .then()
                    .log().all()
                    .statusCode(404);
    }
}
