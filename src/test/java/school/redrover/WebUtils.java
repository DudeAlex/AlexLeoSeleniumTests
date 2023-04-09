package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebUtils {
    public static void copyright(String[] pages) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://redrover.school");

        for (int i = 0; i < pages.length; i++) {
            driver.findElement(new By.ByLinkText(pages[i])).click();
            String copyright = driver.findElement(By.xpath("//*[contains(text(), 'Copyright ©')]")).getText();
            Assert.assertEquals(copyright, "Copyright © 2022 RedRover School. All rights reserved");
        }
    }
}
