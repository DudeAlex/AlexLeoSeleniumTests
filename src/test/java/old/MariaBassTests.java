package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class MariaBassTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Ignore
    @Test
    public void testCheckSaleTag_TC_001() {

        WebElement featuredProducts = driver.findElement(By.xpath(
                "//ul[@class = 'products columns-5']"));
        List<WebElement> items = featuredProducts.findElements(By.tagName("li"));
        for (WebElement item : items) {
            int numberOfElements = item.findElements((By.tagName("bdi"))).size();
            boolean onSaleTag;
            if (numberOfElements == 2) {
                WebElement sale = item.findElement(By.className("onsale"));
                onSaleTag = sale != null;
                Assert.assertTrue(onSaleTag);
            }
        }
    }
    @Ignore
    @Test
    public void testDollarSignPresence_TC_002() {
        WebElement featuredProducts = driver.findElement(By.
                xpath("//ul[@class = 'products columns-5']"));
        List<WebElement> items = featuredProducts.findElements(By.tagName("li"));

        for (WebElement item : items) {
            String[] allItemText = item.getText().split("\n");
            Assert.assertTrue(allItemText[allItemText.length - 2].contains("$"));
        }
    }
    @Ignore
    @Test
    public void verifyDiscountMethodTest_TC_003() {
        WebElement block1 = driver.findElement(By.
                xpath("//div[@class = 'wp-block-cover alignfull has-background-dim']"));
        String allText = block1.getText();
        Assert.assertTrue(allText.contains("25% OFF On all products"));
    }
}
