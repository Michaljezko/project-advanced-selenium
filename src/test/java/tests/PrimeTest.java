package tests;

import Base.TestBase;
import helpers.ExcelReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class PrimeTest extends TestBase {
    private static final String TEST_DATA_PATH = "src/test/resources/data.xlsx";
    private static final String SHEET = "prime";



    @Test
    public void testPrime() throws IOException {
        getDriver().get(BASE_URL + "primenumber.php");
        WebElement numberInput = getDriver().findElement(By.xpath("//input[@type='number']"));
        WebElement button = getDriver().findElement(By.cssSelector("button.btn"));
        ExcelReader primeExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);
        for (Row cells : sheet) {
            if (cells.getRowNum() == 0) {
                continue;
            }
            numberInput.clear();
            numberInput.sendKeys(String.valueOf((int) cells.getCell(0).getNumericCellValue()));

            boolean expectedPrime = cells.getCell(1).getBooleanCellValue();
            button.click();
//            if (expectedPrime == true) {
//            new WebDriverWait(getDriver(), 5)
//            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
//            } else {
//            new WebDriverWait(getDriver(), 5)
//            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
//            }

        }
    }

//    @Test
//    public void testPrimeSecond() throws IOException {
//        WebElement numberInput = getDriver().findElement(By.xpath("//input[@type='number']"));
//        WebElement button = getDriver().findElement(By.cssSelector("button.btn"));
//        ExcelReader primeExcelReader = new ExcelReader(TEST_DATA_PATH);
//        Sheet sheet = primeExcelReader.getSheetByName(SHEET);
//        for (Row cells : sheet) {
//            if (cells.getRowNum() == 0) {
//                continue;
//            }
//            int number = (int) cells.getCell(0).getNumericCellValue();
//            numberInput.clear();
//            numberInput.sendKeys(String.valueOf(number));
//            boolean expectedPrime = cells.getCell(1).getBooleanCellValue();
//            button.click();
//            checkResult(expectedPrime);

//        }
//    }
//    private void checkResult(boolean expectedPrime) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//
//        if (expectedPrime) {
//            new WebDriverWait(getDriver(), Duration.ofSeconds(5))
//            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));

//            } else {
//            new WebDriverWait(getDriver(), Duration.ofSeconds(5))
//            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
//
//        }
//    }
}

