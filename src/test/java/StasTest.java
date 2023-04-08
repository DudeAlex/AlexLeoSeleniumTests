import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StasTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");


        driver = new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com");
        driver.manage().window().maximize();
    }
    @AfterMethod

    public void afterMethod() {
        driver.quit();
    }

    @Test

    public void verifySale_TC_001_04() {


        WebElement saleSign = driver.findElement(By.className("onsale"));
        Assert.assertEquals(saleSign.getText(), "Sale!");


    }


}




