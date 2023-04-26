package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
@Ignore
public class MikeBTest {

    private WebDriver driver;

    @BeforeMethod
    private void beforeMethod() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*", "headless", "--window-size=1920,1080");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    private void afterMethod() {
        driver.quit();
    }


    @Test

    public void testFieldValidation() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String fieldValidation = driver.findElement(By.xpath("//h2[@class='has-text-align-center']")).getText();
        Assert.assertEquals(fieldValidation, "Featured Products");

        String saleTag = driver.findElement(By.xpath("//span[@class='onsale']")).getText();
        Assert.assertEquals(saleTag, "Sale!");
    }

    @Test

    public void testCurrencyValidation() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String currencyValidation = driver.findElement(By.xpath("//span[@class='woocommerce-Price-currencySymbol']"))
                .getText();
        Assert.assertEquals(currencyValidation, "$");

    }

    @Test

    public void testDiscountCheckt() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String discountCheck = driver.findElement(
                By.xpath("//h3[@class='has-text-align-center has-white-color has-text-color has-medium-font-size']"))
                .getText();
        Assert.assertEquals(discountCheck, "25% OFF On all products");

    }

    @Test

    public void testCheckMenuItem() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.findElement(By.xpath("//li[@id=\"menu-item-1237\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");

    }

    @Test

    public void testValidateWebsitet() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");

    }

    @Test

    public void testConfirmAllProducts() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        WebElement allProducts = driver.findElement(By.xpath("//ul[@class='products columns-5']"));
        List<WebElement> products = allProducts.findElements(By.tagName("li"));
        Assert.assertEquals(products.size(), 5);
    }

    @Test
    public void testWebDrive() {

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");

        WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='wp-block-group alignfull']"));
        List<WebElement> products = featuredProducts.findElements(By.tagName("li"));

        for (WebElement elem : products) {
            List<WebElement> x = elem.findElements(By.tagName("h2"));
            System.out.println(x.size());
        }
    }

    @Test
    public void testBestSeller() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");

        WebElement bestSeller = driver.findElement(By.xpath("//ul[@class='product_list_widget']"));
        List<WebElement> validateProducts = bestSeller.findElements(By.tagName("li"));

        for (WebElement sort : validateProducts) {
            List<WebElement> dollarSign = sort.findElements(By.tagName("bdi"));
            if (dollarSign.size() > 1) {
                System.out.println(dollarSign.get(1).getText());
            } else {
                System.out.println(dollarSign.get(0).getText());
            }
        }
    }

    @Test
    public void testSelenium() {
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");

        WebElement area = driver.findElement(By.id("woocommerce_top_rated_products-3"));
        List<WebElement> dollarSign = area.findElements(By.xpath("//span[@class='woocommerce-Price-currencySymbol']"));

        System.out.println(dollarSign.size());

    }

}


//        System.out.println(products.get(0).getAttribute("baseURI"));
// System.out.println(products.get(0).getAttribute("textContent"));
//        System.out.println(products.get(0).findElement(By.tagName("h2")).getAttribute("textContent"));
//        System.out.println(products.get(0).findElement(By.tagName("h2")).getText());
//        System.out.println(products.get(0).findElement(By.tagName("h2")).getAttribute("outerHTML"));
//        System.out.println(products.get(0).findElement(By.tagName("h2")).getAttribute("innerHTML"));


