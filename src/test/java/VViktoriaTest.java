import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class VViktoriaTest {
    @Test
    public void buttonOpened_TC_009(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        String url = "https://askomdch.com/store";

        driver.findElement(By.cssSelector("div.wp-block-button>a[href=\"/store\"]")).click();
        Assert.assertEquals(url, "https://askomdch.com/store");
        driver.quit();
    }

    @Test
    public void searhButton_TC_009_01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");

        String wordOfSearch = "jea";

        driver.findElement(By.cssSelector("div.wp-block-button>a[href=\"/store\"]")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys(wordOfSearch);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        driver.findElement(By.cssSelector("[class=\"products columns-4\"]")).isDisplayed();

        Assert.assertSame("jea", wordOfSearch);
        driver.quit();
    }
}
