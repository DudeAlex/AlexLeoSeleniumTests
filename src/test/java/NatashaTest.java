import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class NatashaTest extends BaseTest {

    @Test
    public void testVerifySaleIcon() {
        String SITE_NAME = "AskOmDch – Become a Selenium automation expert!";
        Assert.assertEquals(getDriver().getTitle(), SITE_NAME);

        getDriver().findElement(By.xpath("//span[@class='onsale']")).isDisplayed();
        boolean check = getDriver().findElement(By.xpath("//span[@class='onsale']")).isDisplayed();
        Assert.assertTrue(check);
    }

    @Test
    public void testValidate$SignIsPresent() {
        boolean check = getDriver().findElement(By.xpath("//li[contains(@class,'product_cat-womens-jeans')]/div/"
                + "a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']/.."
                + "/../div[2]/span[2]/span/bdi/span")).isDisplayed();
        Assert.assertTrue(check);
    }

    @Test
    public void testVerifyTheDiscountMessageIsPresent() {
        WebElement discountSign = getDriver().findElement(By.xpath("//*[text()='25% OFF On all products']"));
        Assert.assertEquals(discountSign.getText(), "25% OFF On all products");
    }

    @Test
    public void testVerifyTheLoginPageIsOpens() {
        WebElement accountButton = getDriver().findElement(By.xpath("//*[@id='menu-item-1237']"));
        accountButton.click();
        Assert.assertEquals(getDriver().getTitle(), "Account – AskOmDch");
    }

    @Test
    public void testVerifyTheStorePageIsOpened() {
        WebElement shopNowButton = getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']"));
        shopNowButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/store");
    }

    @Test
    public void testFeaturedProductsDisplayed() {
        List<WebElement> products = getDriver().findElements(By.xpath("//a[@class='ast-loop-product__link']"));
        assertEquals(products.size(), 5);
    }

    @Test
    public void testVerifyTheBackgroundColorOfTheSearchButton() {
        getDriver().findElement(By.xpath("//li[@id='menu-item-1228']")).click();

        WebElement searchButton = getDriver().findElement(By.xpath("//button[@value='Search']"));
        assertEquals(searchButton.getCssValue("background-color"), "rgba(49, 151, 214, 1)");
    }

    @Test
    public void testRedirectionToContactUsPage() {
        getDriver().findElement(By.xpath("//*[text()='Find More']")).click();
        Assert.assertEquals(getDriver().getTitle(), "Contact Us – AskOmDch");

        boolean check = getDriver().findElement(By.xpath("//h1[text()='Contact Us']")).isDisplayed();
        Assert.assertTrue(check);
    }

    @Test
    public void testVerifyNumberOfProductsDisplayed() {
        WebElement womenButton = getDriver().findElement(By.id("menu-item-1229"));
        womenButton.click();

        WebElement womenProducts = getDriver().findElement(By.xpath("//ul[@class='products columns-4']"));
        List<WebElement> products = womenProducts.findElements(By.tagName("li"));
        assertEquals(products.size(), 7);
    }
}
