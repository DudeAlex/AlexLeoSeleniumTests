import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class AlexLeoGroupJenkins06Tests extends BaseTest {

    @Test
    public void testVerifyLogoJenkinsIsPresent() {
        WebElement element = getDriver().findElement(By.cssSelector("img#jenkins-head-icon"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void testVerifyWordIconJenkinsPresent() {
        WebElement logoWord = getDriver()
                .findElement(By.id("jenkins-name-icon"));
       Assert.assertTrue(logoWord.isDisplayed());
    }
;    @Test
    public void testIconVerification(){
        WebElement icon=getDriver().findElement(By.xpath("//h1[text()='Welcome to Jenkins!']"));
        Assert.assertEquals(icon.getText(),"Welcome to Jenkins!");
    }
}
