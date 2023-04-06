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


public class KsutitovaTest {

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
    public void verifyTheDiscountMessageTest() {

        String discountMessage = driver.findElement
                (By.xpath("//div[@class='wp-block-column is-vertically-aligned-center']/h3")).getText();
        Assert.assertEquals(discountMessage, "25% OFF On all products");
    }


    @Test
    public void clickAccountButtonTest() {

        driver.findElement(By.xpath("//li[@id='menu-item-1237']/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
    }

    @Test
    public void VerifyFiveCardTest() {

        List<WebElement> rezult = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']"));
        Assert.assertEquals(rezult.size(), 5);
    }


    @Test
    public void VerifyCardOnWomenPageeTest() {

        driver.findElement(By.xpath("//li[@id='menu-item-1229']/a")).click();

        List<WebElement> womenProducts = driver.findElements(By.xpath("//div[@class='astra-shop-thumbnail-wrap']"));
        Assert.assertEquals(womenProducts.size(), 7);
    }

}
