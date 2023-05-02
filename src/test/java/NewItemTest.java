import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class NewItemTest extends BaseTest {

    private WebDriverWait wait;

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(3));
    }

    @Test
    public void testVerifyNewItemsList() {
        List<String> listOfNewItemsExpect = Arrays.asList("Freestyle project", "Pipeline", "Multi-configuration project", "Folder", "Multibranch Pipeline", "Organization Folder");

        getDriver().findElement(By.cssSelector("a[href='/view/all/newJob']")).click();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label > span")));
        List<WebElement> listOfNewItems = getDriver().findElements(By.cssSelector("label > span"));

        for (int i = 0; i < listOfNewItemsExpect.size(); i++) {
            Assert.assertEquals(listOfNewItems.get(i).getText(), listOfNewItemsExpect.get(i));
        }
    }

    @Test
    public void testVerifyButtonIsDisabled() {
        getDriver().findElement(By.cssSelector("a[href='/view/all/newJob']")).click();

        WebElement button = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("ok-button")));

        Assert.assertFalse(button.isEnabled());
    }
}
