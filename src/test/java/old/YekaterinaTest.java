package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.List;

@Ignore
public class YekaterinaTest extends BaseTest {
    @Test
    public void testAccountButton() {
        getDriver().findElement(By.id("menu-item-1237")).click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/account/");
    }

    @Test
    public void testShopNowButton() {
        getDriver().findElement(By.xpath("//a[@href='/store']")).click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/store");
    }

    @Test
    public void testDiscountMessage() {
        String message = getDriver().findElement(By.xpath("//h3[contains(text(),'25% OFF')]")).getText();

        Assert.assertEquals(message, "25% OFF On all products");
    }

    @Test
    public void testSaleIcon() {
       List<WebElement> saleIcons = getDriver().findElements(By.className("onsale"));
        for (WebElement saleIcon : saleIcons) {

            Assert.assertTrue(saleIcon.isDisplayed());
        }
    }

    @Test
    public void testProductsNumber() {
        List<WebElement> products = getDriver().findElements(By.className("type-product"));

        Assert.assertEquals(products.size(), 5);
    }

    @Test
    public void testDollarSign() {
        List<WebElement> prices = getDriver().findElements(By.xpath("//span[@class='price']"));
        for (WebElement price : prices) {

            Assert.assertTrue(price.getText().contains("$"));
        }
    }

    @Test
    public void testButtonColor() {
        getDriver().findElement(By.xpath("//li[@id='menu-item-1228']")).click();
        String searchButton = getDriver().findElement(By.xpath("//button[@value='Search']"))
                .getCssValue("background-color");

        Assert.assertEquals(searchButton, "rgba(49, 151, 214, 1)");
    }

    @Test
    public void testContactUsPage() {
        getDriver().findElement(By.xpath("//a[text()='Find More']")).click();

        Assert.assertEquals(getDriver().getTitle(), "Contact Us – AskOmDch");
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='Contact Us']")).getText(), "Contact Us");
    }
}


