import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PetroMatsiuraTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void saleTest_TC_001_23() {
        driver.findElement(By.cssSelector("a[href='https://askomdch.com/product/basic-blue-jeans/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.onsale")).getText(), "Sale!");
        driver.navigate().back();
        driver.findElement(By.cssSelector("a[href='https://askomdch.com/product/anchor-bracelet/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.onsale")).getText(), "Sale!");
    }

    @Test
    public void currencyTest_TC_002_23() {
        for (WebElement element : driver.findElements(By.cssSelector("span[class*='currencySymbol']"))) {
            Assert.assertEquals(element.getText(), "$");
        }
    }

    @Test
    public void discountTest_TC_003_23() {
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[class*='medium-font-size']")).
                getText(), "25% OFF On all products");
    }

    @Test
    public void accountTest_TC_004_23() {
        driver.findElement(By.cssSelector("li#menu-item-1237")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
    }

    @Test
    public void shopTest_TC_005_23() {
        driver.findElement(By.cssSelector("a.wp-block-button__link")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
    }

    @Test
    public void productsNumberTest_TC_006_23() {
        Assert.assertEquals(driver.findElement(By.cssSelector("ul.products.columns-5")).
                findElements(By.tagName("li")).size(), 5);
    }

    @Test
    public void colourTest_TC_007_23() {
        driver.findElement(By.cssSelector("a[href*='men']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("button[value='Search']")).
                getCssValue("background-color"), "rgba(49, 151, 214, 1)");
    }

    @Test
    public void findMoreButtonTest_TC_008_23() {
        driver.findElement(By.cssSelector("div.wp-block-button.is-style-fill")).click();
        Assert.assertEquals(driver.getTitle(), "Contact Us – AskOmDch");
    }
}
