import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TatsiPkTest {

    @Ignore
    @Test
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

    @Test
    public void Test_TC_003_Original() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");

        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("//h3[contains(text(), '25%')]"));
        Assert.assertEquals(text.getText(), "25% OFF On all products");

        driver.quit();
    }
}
