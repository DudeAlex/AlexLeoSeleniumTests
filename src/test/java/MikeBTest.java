import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MikeBTest {

    @Test
    //Home Page | Featured Products: Verify "Sale!" icon is present on sale products
    public void Test_TC_001_01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String fieldValidation = driver.findElement(By.xpath("//h2[@class=\"has-text-align-center\"]")).getText();
        Assert.assertEquals(fieldValidation, "Featured Products");
        Thread.sleep(2000);

        String saleTag = driver.findElement(By.xpath("//span[@class=\"onsale\"]")).getText();
        Assert.assertEquals(saleTag, "Sale!");
        driver.quit();


    }

    @Test
    //Home Page | Featured Products: Validate "$" sign is present under all displayed products
    public void Test_TC_002_02() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String currencyValidation = driver.findElement(By.xpath("//span[@class=\"woocommerce-Price-currencySymbol\"]")).getText();
        Assert.assertEquals(currencyValidation, "$");
        Thread.sleep(3000);
        driver.quit();


    }

    @Test
    //Home Page: Verify the discount message is presented on the page
    public void Test_TC_003_03() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String discountCheck = driver.findElement(By.xpath("//h3[@class=\"has-text-align-center has-white-color has-text-color has-medium-font-size\"]")).getText();
        Assert.assertEquals(discountCheck, "25% OFF On all products");
        Thread.sleep(3000);

        driver.quit();


    }

    @Test
    //Home Page: Verify the Login page is opened after clicking on the "Account" button
    public void Test_TC_004_04() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.findElement(By.xpath("//li[@id=\"menu-item-1237\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
        Thread.sleep(2000);

        driver.quit();


    }

    @Test
    //Home Page: Verify the Store page is opened after clicking on the "Shop Now" button
    public void Test_TC_005_05() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.findElement(By.xpath("//a[@class=\"wp-block-button__link\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
        Thread.sleep(3000);

        driver.quit();


    }

    @Test
    //Home Page | Featured Products: Verify number of products displayed
    public void Test_TC_006_06() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        WebElement allProducts = driver.findElement(By.xpath("//ul[@class=\"products columns-5\"]"));
        List<WebElement> products = allProducts.findElements(By.tagName("li"));
        Assert.assertEquals(products.size(), 5);

        driver.quit();


    }


}







