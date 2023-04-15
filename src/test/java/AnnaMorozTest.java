import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class AnnaMorozTest extends BaseTest {
    @Test
    //TC_002.06 Home Page | Featured Products: Validate "$" sign is present under all displayed products
    public void testSecondOriginal() {

        String text = getDriver().findElement(By.cssSelector("h2.has-text-align-center")).getText();

        Assert.assertEquals(text,"Featured Products");

        String symbol = getDriver().findElement(By.cssSelector("span.woocommerce-Price-currencySymbol")).getText();

        Assert.assertEquals(symbol,"$");
    }

    @Test
    public void testOpenShop() {

        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        String text = getDriver().findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).getText();

        Assert.assertEquals(text,"Store");
    }

    @Test
    public void testCheckSale() {

        List<WebElement> listFeaturedProducts = getDriver().findElements(By.className("astra-shop-thumbnail-wrap"));
        List<WebElement> listFeaturedProductsText = getDriver().findElements(By.className("astra-shop-summary-wrap"));
        for (int i = 0; i < listFeaturedProductsText.size(); i++) {
            String[] arrProductText = listFeaturedProductsText.get(i).getText().split("\n");
            if (arrProductText[2].split(" ").length > 1) {
                Assert.assertEquals(listFeaturedProducts.get(i).getText(), "Sale!");
            }
        }
    }

    @Test
    public void testCheckContactUs() {

        getDriver().findElement(By.xpath("//div[@class ='wp-block-button is-style-fill']")).click();
        String textContact  = getDriver().findElement(By.xpath("//h1[@class ='has-text-align-center']")).getText();

        Assert.assertEquals(textContact,"Contact Us");
    }
}
