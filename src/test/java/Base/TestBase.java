package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {


    public static final String BASE_URL = "http://localhost:50/";

    @Before
    public void setUp(){
        WebDriverSingleton.initialize();
    }
    @After
    public void tearDown(){
        WebDriverSingleton.getWebdriverInstance().close();
    }
    public WebDriver getDriver() {
        return WebDriverSingleton.getWebdriverInstance();
    }
}
