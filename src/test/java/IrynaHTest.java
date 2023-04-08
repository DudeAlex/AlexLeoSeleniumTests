import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IrynaHTest {

    private WebDriver driver;
    private final By SALE25_TEXTh3 = By.xpath("//h3[contains(text(), '25%')]");

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://askomdch.com/");
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void TwFiveOFFOnAllProductsText() throws InterruptedException {

        String expectedResult = "25% OFF On all products";

        String actualResult = driver.findElement(SALE25_TEXTh3).getText();
        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(1000);
    }
}
