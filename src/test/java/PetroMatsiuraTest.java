import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PetroMatsiuraTest {
    @Test
    public void saleTest_TC_001_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href*='/basic-blue-jeans/']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("span.onsale")).getText(), "Sale!");
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href*='/anchor-bracelet/']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("span.onsale")).getText(), "Sale!");
        driver.quit();
    }

    @Test
    public void currencyTest_TC_002_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        Thread.sleep(2000);

        List<WebElement> listProducts = driver.findElements(By.cssSelector("span[class*='currencySymbol']"));
        for (WebElement element : listProducts) {
            Assert.assertEquals(element.getText(), "$");
        }
        driver.quit();
    }

    @Test
    public void discountTest_TC_003_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[class*='medium-font-size']")).
                getText(), "25% OFF On all products");
        driver.quit();
    }

    @Test
    public void accountTest_TC_004_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li#menu-item-1237")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
        driver.quit();
    }

    @Test
    public void shopTest_TC_005_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a.wp-block-button__link")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
        driver.quit();
    }

    @Test
    public void productsNumberTest_TC_006_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("ul.products.columns-5")).
                findElements(By.tagName("li")).size(), 5);
        driver.quit();
    }

    @Test
    public void colourTest_TC_007_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href*='men']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("button[value='Search']")).
                getCssValue("background-color"), "rgba(49, 151, 214, 1)");
        driver.quit();
    }
}
