
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class GannaTest {
    @Test
    public void testVerifyProdDisplayedTC_006() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"AskOmDch – Become a Selenium automation expert!");
        List <WebElement> elements = driver.findElements(By.xpath("//div[@class='astra-shop-thumbnail-wrap']"));
        Thread.sleep(3000);
        Assert.assertEquals(elements.size(), 5);
        System.out.println("The amount of the product displayed is" +" " + elements.size());
        driver.quit();


    }


    @Test
     public void testStorePageIsOpenedTC_005() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href=\"/store\"]")).click();
        String expectedUrl = "https://askomdch.com/store";
        driver.get(expectedUrl);
        try {
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Navigated to the correct store page");
        }
        catch (Throwable pageNavigationError) {
            System.out.println("Did not navigate to correct page");
        }
        Thread.sleep(2000);
        driver.quit();
    }

    @Test

    public void testLoginPageIsOpenedTC_004() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id=\"menu-item-1237\"]")).click();
        String expectedUrl = "https://askomdch.com/account/";
        driver.get(expectedUrl);
        try {
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Navigated to the correct login page");
        }
        catch (Throwable pageNavigationError) {
            System.out.println("Did not navigate to correct page");
        }
        Thread.sleep(2000);
        driver.quit();

    }

    @Test

    public void testVerifyTheDiscountMessageTC_003() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[contains(text(), \"25% OFF \")]"));
        Thread.sleep(2000);
        System.out.println("Discount message is present");
        driver.quit();
    }

    @Test

    public void testValidate_$_SignIsPresent () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(2000);
        boolean sign = driver.findElement(By.xpath("//span[@class ='onsale']")).isDisplayed();
        if (sign) {
            System.out.println("Signs are displayed");
        }
        else {
            System.out.println("Signs are not displayed");
        }
        driver.quit();
    }
}
