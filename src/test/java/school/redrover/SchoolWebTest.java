package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Year;

public class SchoolWebTest {
    @Test
    public void testTeachersCopyright() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://redrover.school");
        driver.findElement(By.linkText("Teachers")).click();

        //get the string with copyright
        String copyright = driver.findElement(By.xpath("//*[contains(text(), 'Copyright ©')]")).getText();

        //assert to see that year in copyright matches the current year
        Assert.assertEquals(copyright.substring(12, 16), Year.now().toString());

    }
}
