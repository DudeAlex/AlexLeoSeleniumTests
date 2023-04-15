import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MikeBTest {

    private WebDriver driver;

    @BeforeMethod
    private void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "headless", "--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    private void afterMethod(){
        driver.quit();
    }


    @Test

    public void testFieldValidation() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String fieldValidation = driver.findElement(By.xpath("//h2[@class=\"has-text-align-center\"]")).getText();
        Assert.assertEquals(fieldValidation, "Featured Products");
        Thread.sleep(2000);

        String saleTag = driver.findElement(By.xpath("//span[@class=\"onsale\"]")).getText();
        Assert.assertEquals(saleTag, "Sale!");
    }

    @Test

    public void testCurrencyValidation() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String currencyValidation = driver.findElement(By.xpath("//span[@class=\"woocommerce-Price-currencySymbol\"]")).getText();
        Assert.assertEquals(currencyValidation, "$");
        Thread.sleep(3000);
    }

    @Test

    public void testDiscountCheckt() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String discountCheck = driver.findElement(By.xpath("//h3[@class=\"has-text-align-center has-white-color has-text-color has-medium-font-size\"]")).getText();
        Assert.assertEquals(discountCheck, "25% OFF On all products");
        Thread.sleep(3000);
    }

    @Test

    public void testCheckMenuItem() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.findElement(By.xpath("//li[@id=\"menu-item-1237\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
        Thread.sleep(2000);
    }

    @Test

    public void testValidateWebsitet() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.findElement(By.xpath("//a[@class=\"wp-block-button__link\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
        Thread.sleep(3000);
    }

    @Test

    public void testConfirmAllProducts() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        WebElement allProducts = driver.findElement(By.xpath("//ul[@class=\"products columns-5\"]"));
        List<WebElement> products = allProducts.findElements(By.tagName("li"));
        Assert.assertEquals(products.size(), 5);
    }
}







