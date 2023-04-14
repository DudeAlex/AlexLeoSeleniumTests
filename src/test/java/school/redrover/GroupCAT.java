package school.redrover;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GroupCAT {

    @FindBy(xpath = "//a[@class='btn btn-secondary m-1']")
    public WebElement buttonDocumentation;

    public final static String BASE_URL = "https://www.jenkins.io/";

    public WebDriverWait webDriverWait10;

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public final ChromeOptions chromeOptions() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--window-size=1920,1080");

        return chromeOptions;
    }

    public final WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(chromeOptions());

        WebDriverManager.chromedriver().setup();
        return driver;
    }

    public final void getBaseUrl() {
        driver = createDriver();
        driver.get(BASE_URL);

        PageFactory.initElements(driver, this);
    }

    public final WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return webDriverWait10;
    }

    public final void verifyElementVisible(WebElement element) {

        getWait10().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement verifyElementIsClickable(WebElement element) {
        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }

    public final void clickButtonDocumentation() {
        verifyElementVisible(buttonDocumentation);
        verifyElementIsClickable(buttonDocumentation).click();

    }

    @Test
    public void textVerification() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement mouseHoverOver = driver.findElement(By.id("mousehover"));

        String actualText = mouseHoverOver.getText();
        String expectedText = "Mouse Hover";

        Assert.assertEquals(actualText, expectedText, "Text verification is FAILED");

        driver.quit();

    }

    @Test
    public void dragAndDrop() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://formy-project.herokuapp.com/dragdrop");

        WebElement image = driver.findElement(By.id("image"));

        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(image, box).perform();

        driver.quit();

    }

    @Test

    public void testVerifyRedirectFromJetLabel() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.jetbrains.com/");

        Thread.sleep(3000);

        WebElement label = driver.findElement(By.xpath("//a[@aria-label='Navigate to main page']"));
        label.click();

        WebElement title = driver.findElement(By.xpath("//h1[@class='rs-h1 rs-h1_theme_dark home-page__title']"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.jetbrains.com/");
        Assert.assertEquals(title.getText(), "Essential tools for software developers and teams");

        driver.quit();

    }

    @Test

    public void testVerifyLink() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://smartbear.com/");

        Thread.sleep(3000);

        WebElement carrer = driver.findElement(By.cssSelector("li:nth-child(4) > a"));
        carrer.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://smartbear.com/company/careers/");

        driver.quit();
    }

    @Test
    public void testClickDocumentationButton() {

        final String expectedTitle = "Jenkins User Documentation";

        getBaseUrl();

        clickButtonDocumentation();

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.quit();
    }
}
