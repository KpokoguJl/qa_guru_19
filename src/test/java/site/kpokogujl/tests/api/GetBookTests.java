package site.kpokogujl.tests.api;

import org.junit.jupiter.api.Test;
import site.kpokogujl.tests.TestBaseAPI;

public class GetBookTests extends TestBaseAPI {
    @Test
    void getBookTest(){
        String url = "https://demoqa.com/BookStore/v1/Book?ISBN=9781449325862";

        request()
//                .filter(new AllureRestAssured())
//                .filter(withCustomTemplates())
                .get(url)
                .then()
                .log().all()
                .statusCode(200);

    }
}
