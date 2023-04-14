import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class OksanaTest extends BaseTest {
    WebDriver driver;

    @Test
    public void testContactUs() {
        String text = driver.findElement(By.xpath("//*[@id=\"menu-item-1233\"]/a")).getText();
        Assert.assertEquals(text, "Contact Us");

    }
}
