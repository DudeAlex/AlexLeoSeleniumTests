import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViktoriiaKarpusTest {

    @Test
    public void testAccountLogin_TC_004_01_06() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@id='menu-item-1237']")).click();
        WebElement text = driver.findElement(By.xpath("//h1[@class ='has-text-align-center']"));
        Assert.assertEquals(text.getText(), "Account");
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void testSale_TC_001_010() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(3000);
        String icon = driver.findElement(By.xpath("//span[@class ='onsale']")).getText();
        Assert.assertEquals(icon, "Sale!");
        Thread.sleep(3000);
        driver.quit();
    }


}
