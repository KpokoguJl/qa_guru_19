package site.kpokogujl.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import site.kpokogujl.helpers.CustomAllureListener;

import static io.restassured.RestAssured.given;
import static site.kpokogujl.helpers.CustomAllureListener.withCustomTemplates;

public class GetBookTests {
    @Test
    void getBookTest(){
        String url = "https://demoqa.com/BookStore/v1/Book?ISBN=9781449325862";

        given()
                .filter(withCustomTemplates())
                .get(url)
                .then()
                .log().all()
                .statusCode(200);

    }
}
