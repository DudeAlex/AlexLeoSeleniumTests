package old;

import jdk.jfr.Description;
import net.bytebuddy.TypeCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
@Ignore
public class EvanMaiTest extends BaseTest {

    private WebDriver driver;

    @BeforeMethod
    private void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        getDriver().get("https://askomdch.com/");
    }

    @AfterMethod
    private void afterMethod(){
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

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

    @Test
    public void testVerifySortByPrice() {
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
        List<WebElement> listOfProducts = getDriver().findElements(By.xpath("//a[@data-product_id]"));
        listOfProducts.remove(4);

        for(WebElement we : listOfProducts) {
            we.click();
        }

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        Assert.assertTrue(wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='count']"), "4")));
    }
}
