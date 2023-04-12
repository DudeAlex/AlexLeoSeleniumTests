import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OksanaTest {
    @Test
    public void contactUsTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        String text = driver.findElement(By.xpath("//*[@id=\"menu-item-1233\"]/a")).getText();
        Assert.assertEquals(text, "Contact Us");
        driver.quit();
    }
}
