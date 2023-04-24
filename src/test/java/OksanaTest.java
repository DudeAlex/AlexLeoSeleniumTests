import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class OksanaTest extends BaseTest {

    @Test
    public void testContactUs() {
        String text = getDriver().findElement(By.xpath("//*[@id=\"menu-item-1233\"]/a")).getText();
        Assert.assertEquals(text, "Contact Us");

    }

    @Test
    public void testAccountIsDisplayedOnAccounttPage() {
        getDriver().findElement(By.xpath("//li[@id='menu-item-1237']")).click();
        String text = getDriver().findElement(By.xpath("//h1[@class='has-text-align-center']")).getText();

        Assert.assertEquals(text, "Account");
    }
}
