import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class ElenaRogovaTest extends BaseTest {

    @Test
    public void testVerifySaleIcon() {
        List<WebElement> saleIcons = getDriver().findElements(By.xpath(".//span[text() = 'Sale!']"));
        for (WebElement webElement : saleIcons)
            Assert.assertTrue(webElement.isDisplayed());
    }

    @Test
    public void testValidate$SignUnderFeaturedProducts() {
        List<WebElement> featuredProductsPrices = getDriver().findElements(By.xpath(".//span[@class = 'woocommerce-Price-currencySymbol']"));
        for (WebElement webElement : featuredProductsPrices)
            Assert.assertEquals(webElement.getText(), "$");
    }

    @Test
    public void testVerifyPromoText() {
        WebElement promoText = getDriver().findElement(By.xpath(".//h3[@class = 'has-text-align-center has-white-color has-text-color has-medium-font-size']"));
        Assert.assertEquals(promoText.getText(), "25% OFF On all products");
    }

    @Test
    public void testVerifyLoginPageOpened() {
        WebElement accountButton = getDriver().findElement(By.linkText("Account"));
        accountButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/account/");
        WebElement accountPageTitle = getDriver().findElement(By.xpath(".//h1[text() = 'Account']"));
        Assert.assertTrue(accountPageTitle.isDisplayed());
    }

    @Test
    public void testVerifyStorePageOpened() {
        WebElement storeButton = getDriver().findElement(By.linkText("Store"));
        storeButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/store/");
        WebElement storePageTitle = getDriver().findElement(By.xpath(".//h1[text() = 'Store']"));
        Assert.assertTrue(storePageTitle.isDisplayed());
    }

    @Test
    public void testVerifyNumberOfFeaturedProducts() {
        List<WebElement> featuredProductsPrices = getDriver().findElements(By.xpath(".//ul[@class = 'products columns-5']/li"));
        Assert.assertEquals(featuredProductsPrices.size(), 5);
    }

    @Test
    public void testVerifySearchButtonColour() {
        WebElement menButton = getDriver().findElement(By.xpath(".//li[@id = 'menu-item-1228']//a[text() = 'Men']"));
        menButton.click();
        WebElement searchButton = getDriver().findElement(By.xpath(".//button[text() = 'Search']"));
        String colour = searchButton.getCssValue("background-color");
        Assert.assertEquals(colour, "rgba(49, 151, 214, 1)");
    }

    @Test
    public void testVerifyFindMoreButtonRedirectsToContactUs() {
        WebElement findMoreButton = getDriver().findElement(By.xpath(".//a[text() = 'Find More']"));
        findMoreButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/contact-us/");
        WebElement contactUsPageTitle = getDriver().findElement(By.xpath(".//h1[text() = 'Contact Us']"));
        Assert.assertTrue(contactUsPageTitle.isDisplayed());
    }
}
