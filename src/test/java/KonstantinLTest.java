import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KonstantinLTest extends BaseTest {
    @Test
    public void testSaleIconVerification() {
        WebElement featuredProductsElement = getDriver().findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//div[@class='astra-shop-thumbnail-wrap']/parent::li"));
        for (WebElement featuredProduct : featuredProducts) {
            try {
                String value = featuredProduct.findElement(By.xpath("//del[@aria-hidden='true']"))
                        .getAttribute("aria-hidden");
                if (value.equals("true")) {
                    String sale = featuredProduct.findElement(By.xpath("//span[@class='onsale']")).getText();
                    Assert.assertEquals(sale, "Sale!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @Test
    public void testDollarSignVerification() {
        WebElement featuredProductsElement = getDriver().findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//span[@class='woocommerce-Price-currencySymbol']"));
        for (WebElement featuredProduct : featuredProducts) {
            String sign = featuredProduct.getText();
            Assert.assertEquals(sign, "$");
        }
    }

    @Test
    public void testDiscountMessageVerification() {
        String actualText = getDriver().findElement(By.xpath("//h3[@class='has-text-align-center has-white-color " +
                "has-text-color has-medium-font-size']")).getText();

        String expectedText = "25% OFF On all products";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testLoginPageVerification() {
        getDriver().findElement(By.xpath("//a[@href='https://askomdch.com/account/' and text()='Account']")).click();

        String url = "https://askomdch.com/account/";
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void testStorePageVerification() {
        getDriver().findElement(By.xpath("//a[@href='https://askomdch.com/store/' and text()='Store']")).click();

        String url = "https://askomdch.com/store/";
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void testNumberOfProductsVerification() {
        WebElement featuredProductsElement = getDriver().findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//div[@class='astra-shop-thumbnail-wrap']/parent::li"));

        Assert.assertEquals(featuredProducts.size(), 5);
    }

    @Test
    public void testBackgroundColorVerification() {
        getDriver().findElement(By.xpath("//a[@href='https://askomdch.com/product-category/men/']")).click();
        WebElement button = getDriver().findElement(By.xpath("//button[@type='submit' and @value='Search']"));

        String expectedColor = "rgba(49, 151, 214, 1)";
        Assert.assertEquals(button.getCssValue("background-color"), expectedColor);
    }

    @Test
    public void testFindMorePageVerification() {
        getDriver().findElement(By.xpath("//a[@href='https://askomdch.com/contact-us/' and text()='Find More']")).click();

        String actaulPage = getDriver().getTitle().substring(0, 10);
        String expectedPage = "Contact Us";
        String actualLink = getDriver().getCurrentUrl();
        String expectedLink = "https://askomdch.com/contact-us/";

        Assert.assertEquals(actaulPage, expectedPage);
        Assert.assertEquals(actualLink, expectedLink);
    }

    @Test
    public void testNumberOfProductsDisplayedVerification() {
        getDriver().findElement(By.cssSelector("li[id='menu-item-1229']>a")).click();
        List<WebElement> products = getListOfProducts(getDriver()).findElements(By.xpath("li"));

        Assert.assertEquals(products.size(), 7);
    }

    @Test
    public void testPriceSortingVerification() {
        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        getDriver().findElement(By.xpath("//select[@name='orderby']")).click();
        getDriver().findElement(By.xpath("//option[@value='price']")).click();

        WebElement products1 = getListOfProducts(getDriver());
        List<Double> pageList1 = getPrices(products1);

        getDriver().findElement(By.xpath("//a[@class='page-numbers']")).click();
        WebElement products2 = getListOfProducts(getDriver());
        List<Double> pageList2 = getPrices(products2);

        List<Double> result = new ArrayList<>(pageList1);
        result.addAll(pageList2);

        Assert.assertEquals(result.size(), 13);

        Iterator<Double> iter = result.iterator();
        Double current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            Assert.assertTrue(previous.compareTo(current) <= 0);
            previous = current;
        }
    }

    private List<Double> getPrices(WebElement products) {
        List<WebElement> priceList = products.findElements(By.xpath("//span[@class='price']//ins//bdi | " +
                "//span[@class='price']/span/bdi"));

        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceList) {
            prices.add(Double.parseDouble(element.getText().substring(1)));
        }
        return prices;
    }

    private WebElement getListOfProducts(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='ast-woocommerce-container']" +
                "//ul[@class='products columns-4']"));
    }
}
