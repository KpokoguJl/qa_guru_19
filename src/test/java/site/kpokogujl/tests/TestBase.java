package site.kpokogujl.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import site.kpokogujl.config.TestsConfig;
import site.kpokogujl.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase{

    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());

//        TestBaseAPI.API_BASE_URL = config.getBaseUrl();
//        TestBaseAPI.USER_LOGIN = config.apiLogin();
//        TestBaseAPI.USER_PASSWORD = config.apiPassword();
//        TestBaseAPI.USER_NAME = config.apiUserName();

        String browserName = String.valueOf(config.getBrowser());
        String browserVersion = config.getBrowserVersion();
        String browserResolution = config.getResolution();

        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserSize = browserResolution;

        if (config.getRemote()){
            String selenoidLogin = config.selenideLogin(),
                    selenoidPassword = config.selenidePassword();

            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub",
                    selenoidLogin, selenoidPassword);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        Attach.attachAsText("Browser: ", browserName);
        Attach.attachAsText("Version: ", browserVersion);
        Attach.attachAsText("Resolution: ", browserResolution);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
