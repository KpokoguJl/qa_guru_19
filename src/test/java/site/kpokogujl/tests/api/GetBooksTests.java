package site.kpokogujl.tests.api;

import org.junit.jupiter.api.Test;
import site.kpokogujl.tests.TestBaseAPI;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetBooksTests extends TestBaseAPI {
    @Test
    void getBooksTestWithSchemaValidation(){

        request()
//                .filter(withCustomTemplates())
                .get("https://demoqa.com/BookStore/v1/Books")
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/get_books_schema.json"));
    }
}
