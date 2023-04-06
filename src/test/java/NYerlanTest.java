import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NYerlanTest {

    private final String SITE_NAME = "AskOmDch – Become a Selenium automation expert!";
    private final String DISCOUNT_INFO = "25% OFF On all products";

    @Test
    public void testAssertSiteTitle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(), SITE_NAME);

        driver.quit();
    }

    @Test
    public void testAssertDiscountInfo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");

        WebElement textDiscount = driver.findElement(By.xpath("//h3[text()='25% OFF On all products']"));

        Assert.assertEquals(textDiscount.getText(), DISCOUNT_INFO);

        Thread.sleep(2000);
        driver.quit();
    }
}
