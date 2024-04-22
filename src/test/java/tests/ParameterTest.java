package tests;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ParameterTest {
    WebDriver driver;
    int number;
    boolean expectedPrime;
@Parameterized.Parameters
public static List<Object[]> getData(){
    return Arrays.asList(new Object[][]{{1, true}, {2, true}, {4, false}, {5, true}});
}

public ParameterTest(int number, boolean expectedPrime){
    this.number = number;
    this.expectedPrime = expectedPrime;
}

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost/primenumber.php");
    }

//    @Test
//    public void testOptimusUsingParameters(){
//
//        WebElement numberInput = driver.findElement(By.xpath("//input[@type='number']"));
//        WebElement button = driver.findElement(By.cssSelector("button.btn"));
//
//        numberInput.clear();
//        numberInput.sendKeys(String.valueOf(number));
//        button.click();
//
//        checkResult(expectedPrime);
//    }

//    private void checkResult(boolean expectedPrime) {
//        if (expectedPrime) {
//            new WebDriverWait(driver, 5)
//            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
//            } else {
//            new WebDriverWait(driver, 5)
//            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
//            }
//
//        }
}
