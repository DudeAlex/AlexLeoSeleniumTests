import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElenaStelnikovaTest {

    @Test
    public void testVerifySaleIcon_001() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");

        Thread.sleep(2000);

        String featuredProductsSection =  driver.findElement(By.xpath("//h2[@class='has-text-align-center']")).getText();
        Assert.assertEquals(featuredProductsSection,  "Featured Products");

        String productsOfSale = driver.findElement(By.xpath("//span[@class='onsale']")).getText();
        Assert.assertEquals(productsOfSale, "Sale!");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testValidateDollarSymbol_002() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");

        Thread.sleep(2000);

        String featuredProductsSection =  driver.findElement(By.xpath("//h2[@class='has-text-align-center']")).getText();
        Assert.assertEquals(featuredProductsSection,  "Featured Products");

        String dollarSymbol = driver.findElement(By.xpath("//span[@class='woocommerce-Price-currencySymbol']")).getText();
        Assert.assertEquals(dollarSymbol, "$");

        Thread.sleep(2000);
        driver.quit();
    }
}
