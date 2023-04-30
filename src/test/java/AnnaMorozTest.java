import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class AnnaMorozTest extends BaseTest {

    @Test
    public void testCheckIconJenkinsOnHeader(){

    Assert.assertTrue(getDriver().findElement(By.cssSelector("img#jenkins-name-icon")).isDisplayed());

    Assert.assertTrue(getDriver().findElement(By.cssSelector("img#jenkins-head-icon")).isDisplayed());
    }

    @Test
    public void testRestAPILink(){

       Assert.assertEquals(getDriver().findElement(By.xpath("//a[@href='api/']")).getText(),"REST API");
    }
}
