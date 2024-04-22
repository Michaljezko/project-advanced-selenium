package tests;

import Base.TestBase;
import categories.SmokeTest;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;

public class WaitForItTest extends TestBase {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Category(SmokeTest.class)
    @Test
    public void checkTitle() {
        getDriver().get(BASE_URL + "waitforit.php");
        expectedException.expect(ComparisonFailure.class);
        expectedException.expectMessage("nesedi title");

        Assert.assertEquals("nesedi title" ,"WAIT FOR IT !!!", getDriver().findElement(By.xpath("//h1")).getText());
    }

    @Test
    @Ignore
    public void checkLegendary() {
        getDriver().get(BASE_URL + "waitforit.php");
        getDriver().findElement(By.id("startWaitForText")).click();

        Assert.assertEquals("dary !!!", getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));
    }
}
