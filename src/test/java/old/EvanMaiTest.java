package old;

import jdk.jfr.Description;
import old.runnerOld.BaseTestOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EvanMaiTest extends BaseTestOld {

    @Test
    public void testSaleIconPresent() {
        getDriver().get("https://askomdch.com/");

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
        getDriver().get("https://askomdch.com/");

        List<WebElement> listFeaturedProductsText = getDriver().findElements(By.className("astra-shop-summary-wrap"));

        for (WebElement webElement : listFeaturedProductsText) {
            String[] arrProductText = webElement.getText().split("\n");

            Assert.assertEquals(arrProductText[2].charAt(0), '$');
        }
    }

    @Test
    public void testVerifyDiscountMessagePresented() {
        getDriver().get("https://askomdch.com/");

        WebElement text = getDriver().findElement(By.xpath("//h3[contains(text(), '25%')]"));

        Assert.assertEquals(text.getText(), "25% OFF On all products");
    }

    @Test
    public void testVerifyLoginPageOpened() {
        getDriver().get("https://askomdch.com/");

        getDriver().findElement(By.linkText("Account")).click();

        Assert.assertEquals(getDriver().findElement(By.className("has-text-align-center")).getText(), "Account");
    }

    @Test
    public void testVerifyStorePageOpened() {
        getDriver().get("https://askomdch.com/");

        getDriver().findElement(By.cssSelector("a[href='/store']")).click();

        WebElement store = getDriver().findElement(By.xpath("//header[contains(@class, 'woocommerce-products-header')]//following::h1"));

        Assert.assertEquals(store.getText(), "Store");
    }

    @Test
    public void testProductsDisplayed() {
        getDriver().get("https://askomdch.com/");

        List<WebElement> list = getDriver().findElements(By.className("astra-shop-thumbnail-wrap"));

        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void testBackgroundColor() {
        getDriver().get("https://askomdch.com/");

        getDriver().findElement(By.cssSelector("a[href='https://askomdch.com/product-category/men/']")).click();

        WebElement buttonSearch = getDriver().findElement(By.cssSelector("button[value='Search']"));

        Assert.assertEquals(buttonSearch.getCssValue("background-color"), "rgba(49, 151, 214, 1)");
    }

    @Test
    public void testVerifyButtonRedirect() {
        getDriver().get("https://askomdch.com/");

        getDriver().findElement(By.xpath("//a[text() ='Find More']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='Contact Us']")).getText(), "Contact Us");
    }

    @Test
    public void testVerifyNumberProducts() {
        getDriver().get("https://askomdch.com/");

        getDriver().findElement(By.cssSelector("a[href='https://askomdch.com/product-category/women/'")).click();

        List<WebElement> listOfProducts = getDriver().findElements(By.className("astra-shop-thumbnail-wrap"));

        Assert.assertEquals(listOfProducts.size(), 7);
    }

    @Test
    public void testVerifySortByPrice() {
        getDriver().get("https://askomdch.com/");

        getDriver().findElement(By.cssSelector("a[href='/store']")).click();

        Select drpSortBy = new Select(getDriver().findElement(By.cssSelector("select[name='orderby']")));
        drpSortBy.selectByValue("price");

        List<WebElement> listOfPrices = getDriver().findElements(By.cssSelector("span[class='price']"));

        double price = 0, price1;
        for (WebElement e : listOfPrices) {
            String[] arrPrice = e.getText().split(" ");
            price1 = Double.parseDouble(arrPrice[arrPrice.length - 1].substring(1));

            Assert.assertTrue(price <= price1);

            price = price1;
        }
    }

    @Description("Verify number on shopping cart")
    @Test
    public void testVerifyNumberShoppingCart() {
        getDriver().get("https://askomdch.com/");

        List<WebElement> listOfProducts = getDriver().findElements(By.xpath("//a[@data-product_id]"));
        listOfProducts.remove(4);

        for(WebElement we : listOfProducts) {
            we.click();
        }

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        Assert.assertTrue(wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='count']"), "4")));
    }
}
