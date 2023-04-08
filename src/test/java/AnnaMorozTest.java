import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnaMorozTest {
    @Test
    public void testSecondOriginal() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://askomdch.com/");
        Thread.sleep(3000);
        String text = driver.findElement(By.cssSelector("h2.has-text-align-center")).getText();
        Assert.assertEquals(text,"Featured Products");
        Thread.sleep(3000);
        String symbol = driver.findElement(By.cssSelector("span.woocommerce-Price-currencySymbol")).getText();
        Assert.assertEquals(symbol,"$");

        driver.quit();

    }
}
