import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

public class OkilaTest {

    @Test

    public void doFirstTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test

    public void checkSalesIcon_TC_001_06() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        Thread.sleep(1000);
        WebElement icon = driver.findElement(By.xpath("//span[@class='onsale']"));
        Assert.assertEquals(icon.getText(), "Sale!");
        Thread.sleep(1000);
        driver.quit();
    }
    @Test

    public void checkDollarSymbol_TC_002_02() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        Thread.sleep(1000);
        WebElement symbol = driver.findElement(By.xpath("//span[@class='woocommerce-Price-currencySymbol']"));
        Assert.assertEquals(symbol.getText(), "$");
        Thread.sleep(1000);
        driver.quit();
    }

    @Test

    public void checkDiscount_TC_003_02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        WebElement discount = driver.findElement(By.xpath("//h3[contains(text(), \"25% OFF \")]"));
        Assert.assertEquals(discount.getText(), "25% OFF On all products");
        driver.quit();
    }

    @Test

    public void checkAccountLogin_TC_004_02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//a[@href=\"https://askomdch.com/account/\"]")).click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//h1[contains(text(), \"Account\")]"));
        Assert.assertEquals(text.getText(), "Account");
        Thread.sleep(1000);
        driver.quit();
    }

    @Test

    public void checkStorePage_TC_005_02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        Thread.sleep(1000);
        WebElement store = driver.findElement(By.xpath("//h1[contains(text(), \"Store\")]"));
        Assert.assertEquals(store.getText(), "Store");
        driver.quit();
    }

    @Test

    public void checkFeaturedProductNumber_TC_006_02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        Reporter.log("Page title check passed");
        WebElement featuredProducts = driver.findElement(By.xpath("//ul[@class=\"products columns-5\"]"));
        Thread.sleep(2000);
        List<WebElement> products = featuredProducts.findElements(By.tagName("li"));
        Assert.assertEquals(products.size(), 5);
        Reporter.log("Product number check passed");
        driver.quit();
    }
}


