import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.List;

public class OksanaTest extends BaseTest {
    @Test
    public void testSideElementTasks() {
        WebElement sidePanel = getDriver().findElement(By.xpath("//div[@id = 'tasks']"));
        List<WebElement> sideElementTask = sidePanel.findElements(By.tagName("a"));
        Assert.assertEquals(sideElementTask.size(), 5);
    }

    @Test
    public void testEnterItemNameIsRequired() {
        String expectedText = "» Required field";
       WebElement newItem = getDriver().findElement(By.xpath("//div[@id = 'tasks']//a[@href='/view/all/newJob']"));
       newItem.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'hudson.model.FreeStyleProject']//parent::label")));
       getDriver().findElement(By.xpath("//input[@name = 'name']"));

       String actualErrorMessage = getDriver().findElement(By.xpath("//div[@class = 'input-help']")).getText();

       Assert.assertEquals(actualErrorMessage, expectedText);

    }

}
