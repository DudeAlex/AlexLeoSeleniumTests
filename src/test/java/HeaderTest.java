import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;

public class HeaderTest extends BaseTest {

    private WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        return wait;
    }

    @Description("Verify the placeholder text in the search field")
    @Test
    public void testSearchFieldPlaceholder(){
        Assert.assertEquals(getDriver().findElement(By.id("search-box")).getAttribute("placeholder"), "Search (CTRL+K)");
    }

    @Description("Verify the status of autocomplete in the search field")
    @Test
    public void testSearchFieldAutocomplete(){
        Assert.assertEquals(getDriver().findElement(By.id("search-box")).getAttribute("autocomplete"), "off");
    }

    @Description("Verify to the search field functionality")
    @Test
    public void testSearchField(){
        WebElement searchBox = getDriver().findElement(By.id("search-box"));
        searchBox.sendKeys("");
        searchBox.sendKeys(Keys.RETURN);

        Assert.assertTrue(getWait().until(ExpectedConditions.textToBe
                (By.xpath("//div[@class='jenkins-app-bar__content']/h1"), "Built-In Node")));
    }
}
