package site.kpokogujl.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import site.kpokogujl.helpers.CustomAllureListener;

import static io.restassured.RestAssured.given;

public class GetBookTests {
    @Test
    void getBookTest(){
        RestAssured.filters(CustomAllureListener.withCustomTemplates());

        String url = "https://demoqa.com/BookStore/v1/Book?ISBN=9781449325862";

        given()
                .get(url)
                .then()
                .log().all()
                .statusCode(200);

    }
}
