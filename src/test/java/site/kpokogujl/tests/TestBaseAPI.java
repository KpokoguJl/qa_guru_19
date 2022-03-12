package site.kpokogujl.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import site.kpokogujl.config.TestsConfig;

public class TestBaseAPI {

    public static String API_BASE_URL;
    public static String USER_LOGIN;
    public static String USER_PASSWORD;
    public static String USER_NAME;

    @BeforeAll
    static void setUp(){
        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());

        API_BASE_URL = config.getBaseUrl();
        USER_LOGIN = config.apiLogin();
        USER_PASSWORD = config.apiPassword();
        USER_NAME = config.apiUserName();
    }

}
