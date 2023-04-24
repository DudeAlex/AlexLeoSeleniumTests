import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class KsutitovaJenkins06Test extends BaseTest {

    @Test
    public void testVerifyLogoJenkinsIsPresent() {
        WebElement element = getDriver().findElement(By.cssSelector("img#jenkins-head-icon"));
        Assert.assertTrue(element.isDisplayed());
    }

}
