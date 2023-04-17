import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

public class TatsiPkTest extends BaseTest {

    @Test
    public void testCheckSalesIcon() throws InterruptedException {

        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        WebElement icon = getDriver().findElement(By.xpath("//span[@class='onsale']"));

        Assert.assertEquals(icon.getText(), "Sale!");
    }

    @Test
    public void testCheckDiscount() throws InterruptedException {

        WebElement discount = getDriver().findElement(By.xpath("//h3[contains(text(), '25%')]"));

        Assert.assertEquals(discount.getText(), "25% OFF On all products");
    }

    @Ignore
    @Test
    //TC_005 Home Page: Verify the Store page is opened after clicking on the "Shop Now" button
    public void testShopNowButton() {
;
        Assert.assertEquals(getDriver().getTitle(), "AskOmDch – Become a Selenium automation expert!");
        getDriver().findElement(By.xpath("//a[@href='/Men']")).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/men/");
    }
}
