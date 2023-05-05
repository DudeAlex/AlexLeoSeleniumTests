import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;


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

    @Test
    public void testVerifyDRPMenu() {
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='breadcrumbBar']/ol/li/a")).getText(), "Dashboard");
    }


    @Test
    public void testManageOldData() {
        getDriver().findElement(By.xpath("//a[@href='/manage']")).click();

        getWait5().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//dt[contains(text(),'Manage Old Data')]"))).click();

        WebElement oldData = getWait5().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main-panel > h1")));
        Assert.assertEquals(oldData.getText(), "Manage Old Data");
        Assert.assertEquals(oldData.getLocation().toString(), "(372, 133)");
        Assert.assertEquals(oldData.getCssValue("font-size").toString(), "25.6px");
        Assert.assertEquals(oldData.getCssValue("font-weight").toString(), "700");

        List<WebElement> listSortTable = getDriver().findElements(By.xpath("//thead //a"));
        Assert.assertEquals(listSortTable.size(), 4);

        Assert.assertTrue(getDriver().findElement(By.id("main-panel")).getText().contains("No old data was found."));
    }
}
