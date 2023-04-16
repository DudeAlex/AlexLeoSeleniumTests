import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class ViktoriiaKarpusTest extends BaseTest {

    @Test
    public void testAccountLogin_TC_004_01_06() {
        getDriver().findElement(By.xpath("//li[@id='menu-item-1237']")).click();
        WebElement text = getDriver().findElement(By.xpath("//h1[@class ='has-text-align-center']"));

        Assert.assertEquals(text.getText(), "Account");
    }

    @Test
    public void testSale_TC_001_010() {
        String icon = getDriver().findElement(By.xpath("//span[@class ='onsale']")).getText();

        Assert.assertEquals(icon, "Sale!");
    }

    @Test
    public void testDiscountMessage_TC_003() {
        WebElement text = getDriver().findElement(By.xpath("//h3[text()='25% OFF On all products']"));

        Assert.assertEquals(text.getText(), "25% OFF On all products");
    }

    @Test
    public void testShopNow_TC_005() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        WebElement pageStore = getDriver().findElement(By.xpath("//h1[contains(text(), \"Store\")]"));

        Assert.assertEquals(pageStore.getText(), "Store");
    }
}
