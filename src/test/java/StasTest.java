import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StasTest {


    @Test

    public void verifySale_TC_001_04() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        driver.manage().window().maximize();
        WebElement saleSign = driver.findElement(By.className("onsale"));
        Assert.assertEquals(saleSign.getText(), "Sale!");

        driver.quit();
    }

//    @Test
//
//    public void discount25_Off_TC_() {
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://askomdch.com");
//        driver.manage().window().maximize();
//        WebElement sign_25_off = driver.findElement();
//
//    }
    }




