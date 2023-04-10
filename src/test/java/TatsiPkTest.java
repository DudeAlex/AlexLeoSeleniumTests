import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TatsiPkTest {

    public void Test_TC_001_Original() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String fieldValidation = driver.findElement(By.xpath("//h2[@class=\"has-text-align-center\"]")).getText();
        Assert.assertEquals(fieldValidation, "Featured Products");

        Thread.sleep(2000);

        String saleTag = driver.findElement(By.xpath("//span[@class=\"onsale\"]")).getText();
        Assert.assertEquals(saleTag, "Sale!");

        driver.quit();
    }
}
