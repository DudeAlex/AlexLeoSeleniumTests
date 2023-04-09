import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NafisaTest {
    @Test
    public void Test_Nafisa_006() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        List<WebElement> products = driver.findElements(By.className("type-product"));
        Assert.assertEquals(products.size(), 5);
        driver.quit();
    }
}
