package tests;

import Base.TestBase;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest extends TestBase {

    @Test
    public void testVendelinIsPresent() {
        getDriver().get(BASE_URL + "tabulka.php");
        List<String> vendelinovia = new ArrayList<>();
        List<WebElement> rows = getDriver().findElements(By.xpath("//table/tbody/tr"));
        vendelinovia = rows.stream()
                .filter(element -> getName(element).equals("Vendelin"))
                .map(this::getSurname)
                .collect(Collectors.toList());
        System.out.println(vendelinovia);

    }

    @Test
    public void tableTest() {
        getDriver().get(BASE_URL + "tabulka.php");
        List<WebElement> rows = getDriver().findElements(By.xpath("//table//tbody//tr"));

        for (WebElement row : rows) {
            if (row.getText().contains("Florian")){
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", row);
            }
        }
    }
    private String getName(WebElement element) {
        return element.findElement(By.xpath("./td[2]")).getText();
    }
    private String getSurname(WebElement element) {
        return element.findElement(By.xpath("./td[3]")).getText();
    }

    @After
    public void tearDown() {

    }

//     <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
//        <dependency>
//            <groupId>org.seleniumhq.selenium</groupId>
//            <artifactId>selenium-java</artifactId>
//            <version>4.16.1</version>
//        </dependency>

//    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
//        <dependency>
//            <groupId>org.seleniumhq.selenium</groupId>
//            <artifactId>selenium-java</artifactId>
//            <version>4.18.1</version>
//        </dependency>
//
//
//
// this is new and red
//    <dependency>
//            <groupId>org.seleniumhq.selenium</groupId>
//            <artifactId>selenium-server-standalone</artifactId>
//            <version>2.53.0</version>
//        </dependency>

}
