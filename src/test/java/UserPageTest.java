import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class UserPageTest extends BaseTest {

    private static final String USER_FULL_NAME = RandomStringUtils.randomAlphanumeric(10);

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(3));
    }

    @Test
    public void testVerifyUserPageMenu() {
        List<String> listMenuExpected = Arrays.asList("People", "Status", "Builds", "Configure", "My Views", "Credentials");

        getDriver().findElement(By.xpath("//a[@class='model-link']")).click();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        List<WebElement> listMenu = getDriver().findElements(By.className("task"));

        for (int i = 0; i < listMenu.size(); i++) {
            Assert.assertEquals(listMenu.get(i).getText(), listMenuExpected.get(i));
        }
    }

    @Test
    public void testVerifyChangeNameUser() {
        getDriver().findElement(By.xpath("//a[@class='model-link']")).click();

        WebElement configure = getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/user/admin/configure']")));
        configure.click();

        WebElement fullName = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='_.fullName']")));
        fullName.clear();
        fullName.sendKeys(USER_FULL_NAME);
        getDriver().findElement(By.xpath("//button[@name='Submit']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//a[@href='/user/admin']")).getText(), USER_FULL_NAME);
    }
}
