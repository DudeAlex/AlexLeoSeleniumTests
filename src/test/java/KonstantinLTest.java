import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class KonstantinLTest {
    @Test
    public void saleIconVerificationTest_TC_001_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        WebElement featuredProductsElement = driver.findElement(By.xpath("//h2[@class='has-text-align-center']"));
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
            } catch (Exception ignored) {}
        }
    }

    @Test
    public void dollarSignVerificationTest_TC_002_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        WebElement featuredProductsElement = driver.findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//span[@class='woocommerce-Price-currencySymbol']"));
        for (WebElement featuredProduct : featuredProducts) {
            String sign = featuredProduct.getText();
            Assert.assertEquals(sign, "$");
        }
    }

    @Test
    public void discountMessageVerificationTest_TC_003_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        String actualText = driver.findElement(By.xpath("//h3[@class='has-text-align-center has-white-color " +
                "has-text-color has-medium-font-size']")).getText();

        String expectedText = "25% OFF On all products";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void loginPageVerificationTest_TC_004_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/account/' and text()='Account']")).click();

        String url = "https://askomdch.com/account/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void storePageVerificationTest_TC_005_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/store/' and text()='Store']")).click();

        String url = "https://askomdch.com/store/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void numberOfProductsVerificationTest_TC_006_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        WebElement featuredProductsElement = driver.findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//div[@class='astra-shop-thumbnail-wrap']/parent::li"));
        Assert.assertEquals(featuredProducts.size(), 5);
    }

    @Test
    public void numberOfProductsVerificationTest_TC_007_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/product-category/men/']")).click();
        WebElement button = driver.findElement(By.xpath("//button[@type='submit' and @value='Search']"));

        String expectedColor = "rgba(49, 151, 214, 1)";
        Assert.assertEquals(button.getCssValue("background-color"), expectedColor);
    }

    @Test
    public void findMorePageVerificationTest_TC_008_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/contact-us/' and text()='Find More']")).click();
        String actaulPage = driver.getTitle().substring(0, 10);
        String expectedPage = "Contact Us";
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://askomdch.com/contact-us/";
        Assert.assertEquals(actaulPage, expectedPage);
        Assert.assertEquals(actualLink, expectedLink);
    }
}
