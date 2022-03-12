package site.kpokogujl.tests.api;

import org.junit.jupiter.api.Test;
import site.kpokogujl.tests.TestBaseAPI;

import static io.restassured.RestAssured.given;
import static site.kpokogujl.helpers.CustomAllureListener.withCustomTemplates;

public class AuthTests extends TestBaseAPI {
    @Test
    public void authTest () {
        String url = API_BASE_URL + "login";

        given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", USER_LOGIN)
                .formParam("Password", USER_PASSWORD)
                .formParam("RememberMe", "false")
                .when()
                .post(url)
                .then()
//                .log().all()
                .statusCode(302);
    }
}
