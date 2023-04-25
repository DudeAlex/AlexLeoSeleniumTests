package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;


@Ignore
public class AlexLeoTest extends BaseTest {

    @Test
    public void testCheckSiteTitle(){
        getDriver().get("https://askomdch.com/");
        Assert.assertEquals(getDriver().getTitle(), "AskOmDch – Become a Selenium automation expert!");
        getDriver().quit();
    }

    @Test
    public void testNumberOfFeaturedProducts(){
        WebElement featuredProducts = getDriver()
                .findElement(By.xpath("//div[@class='wp-block-group alignfull']//ul"));
        List<WebElement> products = featuredProducts.findElements(By.tagName("li"));

        Assert.assertEquals(products.size(), 5);
    }
}


