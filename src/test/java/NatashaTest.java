import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class NatashaTest {
    private WebDriver driver;
    private final String SITE_NAME = "AskOmDch – Become a Selenium automation expert!";


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @Test
    public void VerifySaleIcon_TC_001() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), SITE_NAME);
        driver.findElement(By.xpath("//span[@class='onsale']")).isDisplayed();
        Thread.sleep(2000);
    }

    @Test
    public void Validate$SignIsPresent_TC_002() throws InterruptedException {

        Assert.assertEquals(driver.getTitle(), SITE_NAME);
        driver.findElement(By.xpath("//li[contains(@class,'product_cat-womens-jeans')]/div/"
                + "a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']/.."
                + "/../div[2]/span[2]/span/bdi/span")).isDisplayed();
        Thread.sleep(3000);
    }

    @Test
    public void VerifyTheDiscountMessage_TC_003() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), SITE_NAME);
        WebElement discountSign = driver.findElement(By.xpath("//*[text()='25% OFF On all products']"));
        Assert.assertEquals(discountSign.getText(), "25% OFF On all products");
        Thread.sleep(3000);
    }

    @Test
    public void VerifyTheLoginPage_TC_004() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), SITE_NAME);
        WebElement accountButton = driver.findElement(By.xpath("//*[@id='menu-item-1237']"));
        accountButton.click();
        Assert.assertEquals(driver.getTitle(), "Account – AskOmDch");
        Thread.sleep(3000);
    }

    @Test
    public void VerifyTheStorePageIsOpened_TC_005() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), SITE_NAME);
        WebElement shopNowButton = driver.findElement(By.xpath("//a[@class='wp-block-button__link']"));
        shopNowButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
        Thread.sleep(3000);
    }

    @Test
    public void FeaturedProducts_006() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), SITE_NAME);
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.xpath("//a[@class='ast-loop-product__link']"));
        Assert.assertEquals(products.size(), 5);
    }
    @Test
    public void VerifyTheBackgroundColorOfTheSearchButton_007() {
        driver.findElement(By.xpath("//li[@id='menu-item-1228']")).click();
        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        assertEquals(searchButton.getCssValue("background-color"), "rgba(49, 151, 214, 1)");
    }
}
