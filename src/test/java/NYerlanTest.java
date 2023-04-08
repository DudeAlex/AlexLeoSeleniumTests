import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NYerlanTest {

    private final String SITE_NAME = "AskOmDch – Become a Selenium automation expert!";
    private final String DISCOUNT_INFO = "25% OFF On all products";
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void testAssertSiteTitle() throws InterruptedException {

        Assert.assertEquals(driver.getTitle(), SITE_NAME);

        driver.quit();
    }

    @Test
    public void testAssertDiscountInfo_TC_003_01() throws InterruptedException {

        WebElement textDiscount = driver.findElement(By.xpath("//h3[text()='25% OFF On all products']"));

        Assert.assertEquals(textDiscount.getText(), DISCOUNT_INFO);

        driver.quit();
    }
}
