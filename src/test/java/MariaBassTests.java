import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MariaBassTests extends BaseTest {

    @Test
    public void testNewItemPageContainsSixProjectTypes() {
        getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        List<WebElement> allProjectTypes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
                .xpath("//ul[@class='j-item-options']//span")));
        List<String> allProjectTypesNames = new ArrayList<>();
        for (WebElement projectType : allProjectTypes) {
            allProjectTypesNames.add(projectType.getText());
        }
        List<String> expectedResult = List.of("Freestyle project", "Pipeline", "Multi-configuration project",
                "Folder", "Multibranch Pipeline", "Organization Folder");

        Assert.assertEquals(allProjectTypesNames, expectedResult);
    }

    @Test
    public void testCreatingNewFreestyleProject() {
        getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']")).click();
        getDriver().findElement(By.xpath("//input[@id='name']"))
                .sendKeys("FreeStyle Project 01");
        getDriver().findElement(By.xpath("//span[text()='Freestyle project']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.name("Submit")).click();
        getDriver().findElement(By.tagName("h1"));

        Assert.assertEquals(getDriver().findElement(By.tagName("h1"))
                .getAttribute("outerText"), "Project FreeStyle Project 01");


    }


    @Test
    public void testCreatingAndDisablingFreestyleProject() {
        getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']")).click();
        getDriver().findElement(By.xpath("//input[@id='name']"))
                .sendKeys("FreeStyle Project 01");
        getDriver().findElement(By.xpath("//span[text()='Freestyle project']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.name("Submit")).click();
        getDriver().findElement(By.xpath("//button[normalize-space()='Disable Project']")).click();

        String allTextInTheElement = getDriver().findElement(By.xpath("//form[@id='enable-project']"))
                .getText();
        String[] allTextInTheElementArray = allTextInTheElement.split("\n");

        Assert.assertEquals(allTextInTheElementArray[0], "This project is currently disabled");

    }
}
