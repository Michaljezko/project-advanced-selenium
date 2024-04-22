package tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WaitingTutorialTest {
    // created reference variable for WebDriver
    WebDriver driver;
    @Before
    public void setup() throws InterruptedException {

        // initializing drv variable using FirefoxDriver
        driver=new FirefoxDriver();
        // launching gmail.com on the browser
        driver.get("https://gmail.com");
        // maximized the browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @Test
//    @Ignore
//    public void test() throws InterruptedException {
//
//        // saving the GUI element reference into a "username" variable of WebElement type
//        WebElement username = driver.findElement(By.id("Email"));
//
//        // entering username
//        username.sendKeys("shruti.shrivastava.in");
//
//        // entering password
//        driver.findElement(By.id("Passwd")).sendKeys("password");
//
//        // clicking signin button
//        driver.findElement(By.id("signIn")).click();
//
//        // explicit wait - to wait for the compose button to be click-able
//        WebDriverWait wait = new WebDriverWait(driver,30);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
//        // click on the compose button as soon as the "compose" button is visible
//        driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
//    }
}
