package site.kpokogujl.tests.ui;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import site.kpokogujl.helpers.Auth;
import site.kpokogujl.helpers.PostReview;
import site.kpokogujl.pages.ReviewPage;
import site.kpokogujl.tests.TestBase;

import static io.qameta.allure.Allure.step;

public class ReviewTests extends TestBase {
    Faker faker = new Faker();

    Auth auth = new Auth();
    PostReview postReview = new PostReview();

    @Test
    void addReviewTest() {
        String title = faker.hobbit().character(),
                review = faker.hobbit().location();
        int rating = 5;

        ReviewPage reviewPage = new ReviewPage();

        step("Авторизуюсь через API");
        String cookie = auth.getAuthCookie();

        step("Оставляю отзыв через API");
        postReview.postReview(cookie, title, review, rating);

        step("Открываю страницу отзывов в браузере");
        reviewPage.openPage(cookie);

        //Проверяю, что созданный отзыв отображается
        reviewPage.checkResult(title, review);
    }
}
