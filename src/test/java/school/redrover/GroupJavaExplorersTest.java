package school.redrover;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupJavaExplorersTest {

    @Test
    public void testTrelloTitle(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        String url = "https://trello.com/";
        String expTitle = "Manage Your Team’s Projects From Anywhere | Trello";

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        Assert.assertEquals(driver.getTitle(), expTitle);

        driver.quit();
    }
}
