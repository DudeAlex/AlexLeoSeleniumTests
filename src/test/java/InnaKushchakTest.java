import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InnaKushchakTest {
    @Test
    public void VerifySaleIcon_TC_001() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://askomdch.com");
        Assert.assertEquals(driver.getTitle(),"AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        Thread.sleep(1000);
        WebElement icon = driver.findElement(By.xpath("//span[@class='onsale']"));
        Assert.assertEquals(icon.getText(), "Sale!");
        Thread.sleep(1000);
        driver.quit();


    }
    @Test
    public void OFFOnAllProducts_TC_003() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        Assert.assertEquals(driver.getTitle(),"AskOmDch – Become a Selenium automation expert!");
        String message= driver.findElement(By.xpath("//h3[text()='25% OFF On all products']")).getText();
        Assert.assertEquals(message, "25% OFF On all products");
        Thread.sleep(1000);
        driver.quit();
    }
}
