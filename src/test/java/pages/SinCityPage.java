package pages;

import Base.WebDriverSingleton;
import enumerators.SinType;
import models.Sin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Base.TestBase.BASE_URL;

public class SinCityPage {
    private WebDriver driver;
    private static final String PAGE_URL = "sincity.php";
    @FindBy(name = "title")
    private WebElement titleInput;
    @FindBy(name = "author")
    private WebElement authorInput;
    @FindBy(name = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement confessButton;

    @FindBy(css = "div.sinsListArea")
    private WebElement sinListSection;
    public SinCityPage()  {
        driver = WebDriverSingleton.getWebdriverInstance();
        PageFactory.initElements(driver, this);
    }
    public void openPage(){
        driver.get(BASE_URL + PAGE_URL);
    }
    public void fillSinInformation(Sin sin) {
        titleInput.sendKeys(sin.getTitle());
        authorInput.sendKeys(sin.getAuthor());
        messageInput.sendKeys(sin.getMessage());
    }
    public void markTag(List<SinType> tags){
        for (SinType tag: tags) {
            driver.findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();
        }
    }
    public void confessSin(){
        confessButton.click();
    }
    public void openSinDetail(Sin spiderSin) {
       WebElement listOfSins = sinListSection.findElement(By.cssSelector("ul.list-of-sins"));
       listOfSins.findElement(By.xpath("./li[contains(text(),'" + spiderSin.getTitle() + "')]")).click();
//       new WebDriverWait().until(ExpectedConditions.text;
    }

//    public void checkSinStatus(Sin spiderSin) {
//        //1.chcem najsť element hriechu
//        WebElement listOfSins = driver.findElement(By.cssSelector("ul.list-of-sins"));
//        WebElement actualSin = listOfSins.findElement(By.xpath("./li[contains(text),'"+spiderSin.getTitle()+"']"));
//        //2.chcem z neho vytiahnuť text
//        String actualText = actualSin.findElement(By.cssSelector("p")).getText().trim();
//        //3.porovnat ocakavane a skutocne
//        if (spiderSin.isForgiven()){
//            Assert.assertEquals("forgiven",actualText );
//        }else {
//            Assert.assertEquals("pending",actualText);
//        }
//    }
}
