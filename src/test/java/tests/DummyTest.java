package tests;

import Base.TestBase;
import categories.ReleaseTest;
import categories.SmokeTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(ConcurrentTestRunner.class)
public class DummyTest extends TestBase {
    static int numberOfFailedTests;

    int failed = 0;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setup class");
        numberOfFailedTests = 0;
    }

    @Category(SmokeTest.class)
    @Test
    public void testA() {
//        getDriver().get(BASE_URL + "waitforit.php");
        getDriver().get("http://www.nike.sk");
        System.out.println("A");
        System.out.println("static "+numberOfFailedTests);
        failed++;
        System.out.println(failed);
    }
    @Category({SmokeTest.class, ReleaseTest.class})
    @Test
    public void testB() {
        getDriver().get(BASE_URL + "waitforit.php");
        System.out.println("B");
        numberOfFailedTests++;
        System.out.println("static "+numberOfFailedTests);
        failed = 10;
        System.out.println(failed);
    }

    @Category(ReleaseTest.class)
    @Test
    public void testC() {
        getDriver().get(BASE_URL + "waitforit.php");
        System.out.println("C");
        System.out.println("static "+numberOfFailedTests);
        System.out.println(failed);
    }

    @After
    public void tearDown() {

    }

}
