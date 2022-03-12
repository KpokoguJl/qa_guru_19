package site.kpokogujl.helpers;

import io.qameta.allure.restassured.AllureRestAssured;
import site.kpokogujl.tests.TestBaseAPI;

import static io.restassured.RestAssured.given;

public class Auth extends TestBaseAPI {
    private final String url = API_BASE_URL + "login";

    public String getAuthCookie (){

        return given()
                .filter(new AllureRestAssured())
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", USER_LOGIN)
                .formParam("Password", USER_PASSWORD)
                .formParam("RememberMe", "false")
                .when()
                .post(url)
                .then()
//                .log().all()
                .statusCode(302)
                .extract().cookie("NOPCOMMERCE.AUTH");
    }
}
