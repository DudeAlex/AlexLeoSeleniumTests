import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class OkilaTest extends BaseTest {

    @Test

    public void testCheckSalesIcon() {
        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        WebElement icon = getDriver().findElement(By.xpath("//span[@class='onsale']"));

        Assert.assertEquals(icon.getText(), "Sale!");
    }
    @Test

    public void testCheckDollarSymbol() {
        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        WebElement symbol = getDriver().findElement(By.xpath("//span[@class='woocommerce-Price-currencySymbol']"));

        Assert.assertEquals(symbol.getText(), "$");
    }

    @Test

    public void testCheckDiscount() {
        WebElement discount = getDriver().findElement(By.xpath("//h3[contains(text(), \"25% OFF \")]"));

        Assert.assertEquals(discount.getText(), "25% OFF On all products");
    }

    @Test

    public void testCheckAccountLogin() {
        getDriver().findElement(By.xpath("//a[@href=\"https://askomdch.com/account/\"]")).click();
        WebElement text = getDriver().findElement(By.xpath("//h1[contains(text(), \"Account\")]"));

        Assert.assertEquals(text.getText(), "Account");
    }

    @Test

    public void testCheckStorePage() {
        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        WebElement store = getDriver().findElement(By.xpath("//h1[contains(text(), \"Store\")]"));

        Assert.assertEquals(store.getText(), "Store");
    }

    @Test

    public void testCheckFeaturedProductNumber() {
        WebElement featuredProducts = getDriver().findElement(By.xpath("//ul[@class=\"products columns-5\"]"));
        List<WebElement> products = featuredProducts.findElements(By.tagName("li"));

        Assert.assertEquals(products.size(), 5);

        Reporter.log("Product number check passed");
    }
}


