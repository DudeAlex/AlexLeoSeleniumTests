import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.net.URL;

public class VViktoriaTest extends BaseTest {
    @Test
    public void testButtonOpened_TC_009(){
        String url = "https://askomdch.com/store";
        getDriver().findElement(By.cssSelector("div.wp-block-button>a[href=\"/store\"]")).click();

        Assert.assertEquals(url, "https://askomdch.com/store");
    }
    @Test
    public void testSearhButton_TC_009_01() {
        String wordOfSearch = "jea";
        getDriver().findElement(By.cssSelector("div.wp-block-button>a[href=\"/store\"]")).click();
        getDriver().findElement(By.id("woocommerce-product-search-field-0")).click();
        getDriver().findElement(By.id("woocommerce-product-search-field-0")).sendKeys(wordOfSearch);
        getDriver().findElement(By.cssSelector("[type='submit']")).click();
        getDriver().findElement(By.cssSelector("[class=\"products columns-4\"]")).isDisplayed();

        Assert.assertSame("jea", wordOfSearch);
    }
}
