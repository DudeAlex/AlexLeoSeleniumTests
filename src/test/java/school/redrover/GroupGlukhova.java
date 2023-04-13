package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GroupGlukhova {

    @Test
    public void logInTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.demoblaze.com/");

        WebElement logIn = driver.findElement(By.xpath("//a[@id='login2']"));
        logIn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));

        WebElement enterUserName = driver.findElement(By.xpath("//input[@id='loginusername']"));
        enterUserName.sendKeys("Alex33");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@id='loginpassword']"));
        enterPassword.sendKeys("i#iw\"iZn2JR6BeM>");

        WebElement clickLogIn = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
        clickLogIn.click();

        Assert.assertEquals(clickLogIn.getText(), "Log in");
        driver.quit();
    }

    @Test
    public void  videoAvailabilityAboutUSTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.demoblaze.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));

        WebElement clickAboutUs = driver.findElement(By.xpath("//a[text() = 'About us']"));
        clickAboutUs.click();

        WebElement clickPlayVideo = driver.findElement(By.cssSelector(".video-js .vjs-big-play-button"));
        clickPlayVideo.click();

        Assert.assertEquals(clickPlayVideo.getText(), "");
        driver.quit();
    }

    @Test
    public void  nextIconCarouselTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.demoblaze.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));

        WebElement clickNextIcon = driver.findElement(By.cssSelector(".carousel-control-next-icon"));
        clickNextIcon.click();
        clickNextIcon.click();
        clickNextIcon.click();

        Assert.assertEquals(clickNextIcon.getText(), "");
        driver.quit();
    }
}
