import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    }

    @Test
    public void testFindGitHubEl() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://www.jenkins.io/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.jenkins.io/");

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"sponsorsblock\"]/div[1]/ul/li[6]/a/img"))
                .isDisplayed());
    }

}
