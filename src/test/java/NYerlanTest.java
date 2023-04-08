import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NYerlanTest {

    private final String SITE_NAME = "AskOmDch – Become a Selenium automation expert!";
    private final String DISCOUNT_INFO = "25% OFF On all products";


    @Test
    public void testAssertDiscountInfo_TC_003_01() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement textDiscount = driver.findElement(By.xpath("//h3[text()='25% OFF On all products']"));

        Assert.assertEquals(textDiscount.getText(), DISCOUNT_INFO);

        driver.quit();
    }
}
