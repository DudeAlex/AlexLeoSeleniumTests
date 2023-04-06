import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MariaBassTest {
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

    @Test
    public void checkSaleTag_TC_001() {
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
}

