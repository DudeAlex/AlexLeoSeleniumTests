import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnaMorozTest {
    @Test
    //TC_002.06 Home Page | Featured Products: Validate "$" sign is present under all displayed products
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

    @Test
    public void testOpenShop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://askomdch.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        String text = driver.findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).getText();

        Assert.assertEquals(text,"Store");

        driver.quit();
    }
}
