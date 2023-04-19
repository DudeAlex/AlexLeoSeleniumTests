import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class EvanMaiTest extends BaseTest {

    @Test
    public void testSaleIconPresent() {
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
    public void testDollarSignDisplayed() {
        List<WebElement> listFeaturedProductsText = getDriver().findElements(By.className("astra-shop-summary-wrap"));

        for (WebElement webElement : listFeaturedProductsText) {
            String[] arrProductText = webElement.getText().split("\n");

            Assert.assertEquals(arrProductText[2].charAt(0), '$');
        }
    }

    @Test
    public void testVerifyDiscountMessagePresented() {
        WebElement text = getDriver().findElement(By.xpath("//h3[contains(text(), '25%')]"));

        Assert.assertEquals(text.getText(), "25% OFF On all products");
    }

    @Test
    public void testVerifyLoginPageOpened() {
        getDriver().findElement(By.linkText("Account")).click();

        Assert.assertEquals(getDriver().findElement(By.className("has-text-align-center")).getText(), "Account");
    }

    @Test
    public void testVerifyStorePageOpened() {
        getDriver().findElement(By.cssSelector("a[href='/store']")).click();

        WebElement store = getDriver().findElement(By.xpath("//header[contains(@class, 'woocommerce-products-header')]//following::h1"));

        Assert.assertEquals(store.getText(), "Store");
    }

    @Test
    public void testProductsDisplayed() {
        List<WebElement> list = getDriver().findElements(By.className("astra-shop-thumbnail-wrap"));
        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void testBackgroundColor() {
        getDriver().findElement(By.cssSelector("a[href='https://askomdch.com/product-category/men/']")).click();
        WebElement buttonSearch = getDriver().findElement(By.cssSelector("button[value='Search']"));
        Assert.assertEquals(buttonSearch.getCssValue("background-color"), "rgba(49, 151, 214, 1)");
    }

    @Test
    public void testVerifyButtonRedirect() {
        getDriver().findElement(By.xpath("//a[text() ='Find More']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='Contact Us']")).getText(), "Contact Us");
    }

    @Test
    public void testVerifyNumberProducts() {
        getDriver().findElement(By.cssSelector("a[href='https://askomdch.com/product-category/women/'")).click();

        List<WebElement> listOfProducts = getDriver().findElements(By.className("astra-shop-thumbnail-wrap"));

        Assert.assertEquals(listOfProducts.size(), 7);
    }
}
