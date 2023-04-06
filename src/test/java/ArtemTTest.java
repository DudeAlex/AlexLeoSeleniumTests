import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ArtemTTest {
    @Test
    public void Test_TC_001_33() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://askomdch.com/");
            WebElement featuredProducts = driver
                    .findElement(By.xpath("//*[contains(text(),'Featured Products')]"));
            List<WebElement> saleProducts = featuredProducts
                    .findElements(By.xpath("//li[contains(@class, 'ast-article-single')]" +
                            "[count(.//span[contains(@class, 'woocommerce-Price-currencySymbol')]) > 1]"));
            for (WebElement saleProduct : saleProducts) {
                assertTrue(saleProduct.findElement(By.cssSelector("span.onsale"))
                        .isDisplayed(), "Sale icon not found on a sale product: " + saleProduct.getText());
            }
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

}
