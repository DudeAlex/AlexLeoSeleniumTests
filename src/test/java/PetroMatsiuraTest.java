import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetroMatsiuraTest {
    @Test
    public void saleTest_TC_001_23() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='https://askomdch.com/product/basic-blue-jeans/']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("span.onsale")).getText(), "Sale!");
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='https://askomdch.com/product/anchor-bracelet/']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("span.onsale")).getText(), "Sale!");
        driver.quit();
    }
}
