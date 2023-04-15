import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;


    public class OlgaSafTest extends BaseTest {


        @Test
        public void findDollarSignVerificationTest() {

            WebDriver driver = new ChromeDriver();

            driver.get("https://askomdch.com/");
            WebElement featuredProductsElement = driver.findElement(
                    By.xpath("//h2[@class='has-text-align-center']"));
            List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                    "//span[@class='woocommerce-Price-currencySymbol']"));
            for (WebElement featuredProduct : featuredProducts) {
                String sign = featuredProduct.getText();
                Assert.assertEquals(sign, "$");
            }

            driver.quit();
        }
    }

