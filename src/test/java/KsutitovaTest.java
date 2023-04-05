import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KsutitovaTest {

    @Test
    public void VerifyTheDiscountMessageTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        String discountMessage = driver.findElement
                (By.xpath("//div[@class='wp-block-column is-vertically-aligned-center']/h3")).getText();
        Assert.assertEquals(discountMessage, "25% OFF On all products");
        driver.quit();
    }
}
