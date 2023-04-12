import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ElenaRogovaTest {

    @Test
    public void verifySaleIcon_TC_001() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://askomdch.com");
        List<WebElement> saleIcons = driver.findElements(By.xpath(".//span[text() = 'Sale!']"));
        for (WebElement webElement : saleIcons)
            Assert.assertTrue(webElement.isDisplayed());

        driver.quit();
    }

    @Test
    public void validate$SignUnderFeaturedProducts_TC_002() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://askomdch.com");
        List<WebElement> featuredProductsPrices = driver.findElements(By.xpath(".//span[@class = 'woocommerce-Price-currencySymbol']"));
        for (WebElement webElement : featuredProductsPrices)
            Assert.assertEquals(webElement.getText(), "$");
        driver.quit();
    }

    @Test
    public void verifyPromoText_TC_003() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        WebElement promoText = driver.findElement(By.xpath(".//h3[@class = 'has-text-align-center has-white-color has-text-color has-medium-font-size']"));
        Assert.assertEquals(promoText.getText(), "25% OFF On all products");
        driver.quit();
    }

    @Test
    public void verifyLoginPageOpened_TC_004() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        WebElement accountButton = driver.findElement(By.linkText("Account"));
        accountButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
        driver.quit();
    }

    @Test
    public void verifyStorePageOpened_TC_005() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        WebElement storeButton = driver.findElement(By.linkText("Store"));
        storeButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store/");
        driver.quit();
    }

    @Test
    public void verifyNumberOfFeaturedProducts_TC_006(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://askomdch.com");
        List<WebElement> featuredProductsPrices = driver.findElements(By.xpath(".//ul[@class = 'products columns-5']/li"));
        Assert.assertEquals(featuredProductsPrices.size(), 5);
        driver.quit();
    }
    @Test
    public void verifySearchButtonColour_TC_007(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://askomdch.com");
        WebElement menButton = driver.findElement(By.xpath(".//li[@id = 'menu-item-1228']//a[text() = 'Men']"));
        menButton.click();
        WebElement searchButton = driver.findElement(By.xpath(".//button[text() = 'Search']"));
        String colour = searchButton.getCssValue("background-color");
        Assert.assertEquals(colour, "rgba(49, 151, 214, 1)");
        driver.quit();
    }
    @Test
    public void verifyFindMoreButtonRedirectsToContactUs_TC_008() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        WebElement findMoreButton = driver.findElement(By.xpath(".//a[text() = 'Find More']"));
        findMoreButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/contact-us/");
        driver.quit();
    }
}
