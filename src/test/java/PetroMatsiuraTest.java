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
}
