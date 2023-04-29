import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class NatashaJenkinsTest extends BaseTest {
    @Test
    public void testLogoJenkinsIsPresent() {
        boolean checkLogoJenkins = getDriver().findElement(By.xpath("//img[@id='jenkins-head-icon']")).isDisplayed();
        Assert.assertTrue(checkLogoJenkins);
    }

    //#2
    @Test
    public void testWordJenkinsIsPresent() {
        boolean checkWordJenkins = getDriver().findElement(By.xpath("//img[@id='jenkins-name-icon']")).isDisplayed();
        Assert.assertTrue(checkWordJenkins);
    }

    //#3
    @Test
    public void testSearchBarIsPresent() {
        boolean searchBar = getDriver().findElement(By.xpath("//input[@id='search-box']")).isDisplayed();
        Assert.assertTrue(searchBar);
    }

    //#4
    @Test
    public void testLogOutButtonIsPresent() {
        boolean checkLogOut = getDriver().findElement(By.xpath("//*[contains(text(),'log out')]")).isDisplayed();
        Assert.assertTrue(checkLogOut);
    }

    //#5
    @Test
    public void testLogOutTextIsPresent() {
        String checkLogOut = getDriver().findElement(By.xpath("//*[contains(text(),'log out')]")).getText();
        Assert.assertEquals(checkLogOut, "log out");
    }

    //#6
    @Test
    public void testDashboardWordIsPresent() {
        String dashBoardText = getDriver().findElement(By.xpath("//li[@class='jenkins-breadcrumbs__list-item']//a")).getText();
        Assert.assertEquals(dashBoardText, "Dashboard");
    }

    //#7
    @Test
    public void testNewItemTextIsPresent() {
        String checkNewItem = getDriver().findElement(By.xpath("//span[contains(text(),'New')]")).getText();
        Assert.assertEquals(checkNewItem, "New Item");
    }

    //#8
    @Test
    public void testAPILinkInTheFooter() {
        WebElement apiLinkButton = getDriver().findElement(By.xpath("//a[text()='REST API']"));
        apiLinkButton.click();

        Assert.assertEquals(getDriver().getTitle(), "Remote API [Jenkins]");
    }

    //#9
    @Test
    public void testJenkinsLinkInTheFooter() {
        WebElement jenkinsLinkButton = getDriver().findElement(By.xpath("//a[@rel='noopener noreferrer']"));
        jenkinsLinkButton.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:9090/");
    }

}
