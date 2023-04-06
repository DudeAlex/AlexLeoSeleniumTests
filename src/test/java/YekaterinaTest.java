import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class YekaterinaTest {
    @Test
    //TC_004 Home Page: Verify the Login page is opened after clicking on the "Account" button
    public void accountButtonTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.id("menu-item-1237")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
        driver.quit();
    }

    @Test
    //TC_005 Home Page: Verify the Store page is opened after clicking on the "Shop Now" button
    public void shopNowButtonTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//a[@href='/store']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
        driver.quit();
    }

    @Test
    //TC_003 Home Page: Verify the discount message is presented on the page
    public void discountMessageTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        String message = driver.findElement(By.xpath("//h3[contains(text(),'25% OFF')]")).getText();
        Assert.assertEquals(message, "25% OFF On all products");
        driver.quit();
    }

    @Test
    //TC_001 Home Page | Featured Products: Verify "Sale!" icon is present on sale products
    public void saleIconTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        List<WebElement> saleIcons = driver.findElements(By.className("onsale"));
        for (WebElement saleIcon : saleIcons) {
            Assert.assertTrue(saleIcon.isDisplayed());
        }
        driver.quit();
    }

    @Test
    //TC_006 Home Page | Featured Products: Verify number of products displayed
    public void productsNumberTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        List<WebElement> products = driver.findElements(By.className("type-product"));
        Assert.assertEquals(products.size(), 5);
        driver.quit();
    }

    @Test
    //TC_002 Home Page | Featured Products: Validate "$" sign is present under all displayed products
    public void dollarSignTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        Thread.sleep(3000);
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price']"));
        for (WebElement price : prices) {
            Assert.assertTrue(price.getText().contains("$"));
        }
        driver.quit();
    }
}


