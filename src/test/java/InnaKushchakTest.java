import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InnaKushchakTest {
    private WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://askomdch.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void VerifySaleIcon_TC_001()  {
        WebElement icon = driver.findElement(By.xpath("//span[@class='onsale']"));
        Assert.assertEquals(icon.getText(), "Sale!");



    }
    @Test
    public void OFFOnAllProducts_TC_003()  {
        String message= driver.findElement(By.xpath("//h3[text()='25% OFF On all products']")).getText();
        Assert.assertEquals(message, "25% OFF On all products");

    }
}
