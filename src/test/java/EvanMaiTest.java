import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EvanMaiTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://askomdch.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void Test_TC_001_01() {
        List<WebElement> listFeaturedProducts = driver.findElements(By.className("astra-shop-thumbnail-wrap"));
        List<WebElement> listFeaturedProductsText = driver.findElements(By.className("astra-shop-summary-wrap"));
        for (int i = 0; i < listFeaturedProductsText.size(); i++) {
            String[] arrProductText = listFeaturedProductsText.get(i).getText().split("\n");
            if (arrProductText[2].split(" ").length > 1) {
                Assert.assertEquals(listFeaturedProducts.get(i).getText(), "Sale!");
            }
        }

    }

    @Test
    public void Test_TC_002_01() {
        List<WebElement> listFeaturedProductsText = driver.findElements(By.className("astra-shop-summary-wrap"));
        for (WebElement webElement : listFeaturedProductsText) {
            String[] arrProductText = webElement.getText().split("\n");
            Assert.assertEquals(arrProductText[2].charAt(0), '$');
        }

    }

    @Test
    public void Test_TC_003_01() {
        WebElement text = driver.findElement(By.xpath("//*[@id=\"post-61\"]/div/div[1]/div/div/div/h3"));
        Assert.assertEquals(text.getText(), "25% OFF On all products");
    }

    @Test
    public void Test_TC_004_01_v1() {
        driver.findElement(By.linkText("Account")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
    }

    @Test
    public void Test_TC_004_01_v2() {
        driver.findElement(By.cssSelector("a[href='https://askomdch.com/account/']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
    }

    @Test
    public void Test_TC_004_01_v3() {
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/account/']")).click();
        Assert.assertEquals(driver.findElement(By.className("has-text-align-center")).getText(), "Account");
    }

    @Test
    public void Test_TC_005_01() {
        driver.findElement(By.cssSelector("a[href='/store']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"main\"]/div/header/h1")).getText(), "Store");
    }

    @Test
    public void Test_TC_006_01() {
        List<WebElement> list = driver.findElements(By.className("astra-shop-thumbnail-wrap"));
        Assert.assertEquals(list.size(), 5);
    }
}
