package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {
    private static WebDriver driver;
    static void initialize(){
//
        initializeGoogleChrome();
//        initializeFirefox();
//        initializeSeleniumServer();

//        driver = new FirefoxDriver();


    }

    public static WebDriver getWebdriverInstance(){
        if (driver == null){
          initialize();
        }
        return  driver;
    }

    private static void initializeGoogleChrome(){
       System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
       driver = new ChromeDriver();

//        Headless browser, use these four lines two above need comment
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();

    }

    private static void initializeFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

//        FirefoxProfile profile = new FirefoxProfile();
//        FirefoxOptions options  = new FirefoxOptions();
//        options.setProfile(profile);
//        options.addPreference("browser.download.folderList", 2);
//        options.addPreference("browser.download.dir", "C:\\tmp");
//        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
//        options.addPreference("general.useragent.override", "Mozilla/5.0 (Android 4.4; Mobile; rv:41.0) Gecko/41.0 Firefox/41.0");
//        driver = new FirefoxDriver(options);


        driver = new FirefoxDriver();

    }
//        private static void initializeSeleniumServer(){
//            URL url = null;
//            try {
//                url = new URL("http://127.0.0.1:4444/wd/hub");
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
////            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
//            driver = new RemoteWebDriver(url, getDesireCapabilities("chrome"));
//
//        }
//    private static DesiredCapabilities getDesireCapabilities(String browserName){
//        AvailableBrowserType desireBrowserType;
//        try {
//            desireBrowserType = AvailableBrowserType.valueOf(browserName.toUpperCase());
//        }catch (IllegalArgumentException i){
//            throw new IllegalArgumentException("Browser " + browserName + " not supported");
//        }
//        DesiredCapabilities desiredCapabilities = null;
//
//        switch (desireBrowserType){
//            case CHROME:{
//                desiredCapabilities = DesiredCapabilities.chrome();
//                break;
//            }
//            case FIREFOX:{
//                desiredCapabilities = DesiredCapabilities.firefox();
//                break;
//            }
//        }
//        return desiredCapabilities;
//    }
}
