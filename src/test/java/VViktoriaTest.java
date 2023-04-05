import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VViktoriaTest {
    @Test
    public static void buttonOpened(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        String url = "https://askomdch.com/store";

        driver.findElement(By.cssSelector("div.wp-block-button>a[href=\"/store\"]")).click();
        Assert.assertEquals(url, "https://askomdch.com/store");
        driver.quit();
    }
}
