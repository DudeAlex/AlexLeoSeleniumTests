import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class ArtemTTest extends BaseTest {

    @Test
    public void Test_TC_001_33() {
        getDriver().get("https://askomdch.com/");

        WebElement featuredProducts = getDriver()
                .findElement(By.xpath("//*[contains(text(),'Featured Products')]"));
        List<WebElement> saleProducts = featuredProducts
                .findElements(By.xpath("//li[contains(@class, 'ast-article-single')]" +
                        "[count(.//span[contains(@class, 'woocommerce-Price-currencySymbol')]) > 1]"));

        for (WebElement saleProduct : saleProducts) {
            assertTrue(saleProduct.findElement(By.cssSelector("span.onsale"))
                    .isDisplayed(), "Sale icon not found on a sale product: " + saleProduct.getText());
        }

    }
}
