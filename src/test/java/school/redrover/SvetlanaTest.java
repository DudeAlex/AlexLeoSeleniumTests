package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SvetlanaTest {

    @Test
    public void TitleTest() throws InterruptedException {

        final String EXPLORE_STORIES = "Explore amazing stories";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.montereybayaquarium.org");

        String title = driver.getTitle();
        Assert.assertEquals(title, "Monterey Bay Aquarium");
        Thread.sleep(3000);
        WebElement tabAnimals = driver.findElement(By.xpath("//button[normalize-space()='Animals']"));
        tabAnimals.click();

        WebElement explStories = driver.findElement(By.xpath("//h3[normalize-space()='Explore amazing stories']"));
        Thread.sleep(3000);
        Assert.assertEquals(explStories.getText(), EXPLORE_STORIES);
        driver.quit();
    }
}
