import org.testng.annotations.Test;
import org.openqa.selenium.By;
import runner.BaseTest;
import static org.testng.Assert.assertEquals;

public class YakuninaTest extends BaseTest {

    //TC_004
    @Test
    public void testAccountButtonOpensLoginPage() {
        String title = getDriver().getTitle();
        assertEquals(title, "AskOmDch – Become a Selenium automation expert!");
        getDriver().findElement(By.xpath("//a[@href=\"https://askomdch.com/account/\"][@class=\"menu-link\"]")).click();
        assertEquals("https://askomdch.com/account/", getDriver().getCurrentUrl());
    }

    //TC_005
    @Test
    public void testShopNowButtonOpensUpStorePage() {
        String title = getDriver().getTitle();
        assertEquals(title, "AskOmDch – Become a Selenium automation expert!");
        getDriver().findElement(By.cssSelector("a.wp-block-button__link")).click();
        assertEquals("https://askomdch.com/store", getDriver().getCurrentUrl());
    }
}


