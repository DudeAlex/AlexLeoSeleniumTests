import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class KsutitovaTest<String> {

    @Test
    public void verifyTheDiscountMessageTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");

        String discountMessage = (String) driver.findElement
                (By.xpath("//div[@class='wp-block-column is-vertically-aligned-center']/h3")).getText();
        Assert.assertEquals(discountMessage, "25% OFF On all products");

        driver.quit();
    }


    @Test
    public void clickAccountButtonTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");

        driver.findElement(By.xpath("//li[@id='menu-item-1237']/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");

        driver.quit();
    }

    @Test
    public void VerifyFiveCardTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");

        List<WebElement> rezult = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']"));
        Assert.assertEquals(rezult.size(), 5);

        driver.quit();
    }

}



