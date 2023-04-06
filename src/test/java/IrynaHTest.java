import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrynaHTest {
    @Test
    public void TwFiveOFFOnAllProductsText() throws InterruptedException {

        String expectedResult = "25% OFF On all products";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://askomdch.com/");


        String actualResult = driver.findElement(By.xpath("//*[@id=\"post-61\"]/div/div[1]/div/div/div/h3")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(1000);
        driver.quit();
    }
}
