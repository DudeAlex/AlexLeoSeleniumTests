package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CaramelSurupForJavaTest {

    @Test
    public void artyomDulyaOpenWeatherGuideClick () throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver();

        driver.get("https://openweathermap.org/");
        Thread.sleep(5000);
        WebElement orderSite = driver.findElement(By.xpath("//ul//div//ul/li//a[@href='/guide']"));
        orderSite.click();
        WebElement turnkeyBusinessCard = driver.findElement(
                By.xpath("//main//div[2]/div/div/p[1]/a[text()='complex enterprise systems']"));
        turnkeyBusinessCard.click();

        driver.quit();
    }

    @Test
    public void serhiiHaponyukFirstSeleniumTest() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Selenium");

        Thread.sleep(5000);
//        WebElement accreditation = driver.findElement(By.xpath(
//                "//u[text()='аккредитованных ИТ-компаний']"));
//        accreditation.click();
//        Thread.sleep(5000);
//        WebElement pageITAccreditationOpened = driver.findElement(By.xpath(
//                "//div[@class = 't469__title t-title t-title_lg ']"));

//        driver.quit();

    }
}
