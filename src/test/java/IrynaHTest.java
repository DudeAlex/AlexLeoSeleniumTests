import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class IrynaHTest extends BaseTest {

    private WebDriver driver;
    private final By SALE25_TEXTh3 = By.xpath("//h3[contains(text(), '25%')]");


    @Test
    public void test25OFFOnAllProductsTextTitlePage() {

        String expectedResult = "25% OFF On all products";

        String actualResult = getDriver().findElement(SALE25_TEXTh3).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testFindGitHubElement() {

        getDriver().get("https://www.jenkins.io/");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.jenkins.io/");

        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id='sponsorsblock']/div[1]/ul/li[6]/a/img"))
                .isDisplayed());
    }
}
