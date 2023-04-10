package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;



import static org.testng.Assert.assertEquals;

public class NatalyaKadyshevaFirstTest {
    @Test
    public void eightComponents() throws InterruptedException {
        GoogleChromeOptions googleChromeOptions= new GoogleChromeOptions();
        googleChromeOptions.addArguments("--headless", "--window-size=1920,1080");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        Thread.sleep(2000);

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();
    }

}

