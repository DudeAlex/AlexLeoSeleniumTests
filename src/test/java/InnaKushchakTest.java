import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.List;

public class InnaKushchakTest extends BaseTest {

    @Test
    public void testVerifySaleIcon() {

        WebElement icon = getDriver().findElement(By.xpath("//span[@class='onsale']"));
        Assert.assertEquals(icon.getText(), "Sale!");
    }

    @Test
    public void  testValidate$SignIsPresent() {

        WebElement sign = getDriver().findElement(By.xpath("//span[@class='woocommerce-Price-currencySymbol']"));
        Assert.assertEquals(sign.getText(), "$");
    }

    @Test
    public void testOffOnAllProducts() {

        String message = getDriver().findElement(By.xpath("//h3[text()='25% OFF On all products']")).getText();
        Assert.assertEquals(message, "25% OFF On all products");
    }

    @Test
    public void testVerifyingLogInButton() {

        getDriver().findElement(By.xpath("//a[@href='https://askomdch.com/account/']")).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/account/");
    }

    @Test
    public void testVerifyingShopNowButton() {

        getDriver().findElement(By.xpath("//a[text()='Shop Now']")).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/store");
    }

    @Test
    public void testVerify5ProductsDisplayed() {

        Assert.assertEquals(getDriver().findElement(By.cssSelector("ul.products.columns-5")).findElements(By.tagName("li")).size(), 5);
    }

    @Test
    public void testSearchButtonColorVerification() {

        getDriver().findElement(By.cssSelector("li[id='menu-item-1228']")).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//button[@value='Search']")).getCssValue("background-color"), "rgba(49, 151, 214, 1)");
    }

    @Test
    public void testContactUsButtonVerification() {

        getDriver().findElement(By.cssSelector("div[class='wp-block-button is-style-fill']")).click();
        Assert.assertEquals(getDriver().getTitle(), "Contact Us – AskOmDch");
    }

    @Test
    public void testWebDriver(){

        WebElement featureProducts=getDriver().findElement(By.xpath("//div[@class='wp-block-group alignfull']//ul"));
        List<WebElement> products=featureProducts.findElements(By.tagName("li"));
        for (WebElement elem:products) {
         List<WebElement> x= elem.findElements(By.tagName("h2"));
            System.out.println(x.size());
        }
    }

    @Test
    public void testBestSellers(){
            WebElement bestSellers=getDriver().findElement(By.xpath("//ul[@class='product_list_widget']"));
            List<WebElement> validateProducts= bestSellers.findElements(By.tagName("li"));
            for(WebElement listOfBest:validateProducts){

            }
        }

    @Test
    public void testWebDriverSearch(){

        WebElement featureProducts=getDriver().findElement(By.xpath("//div[@class='wp-block-group alignfull']//ul"));
        List<WebElement> products=featureProducts.findElements(By.tagName("li"));
        products.get(0).getAttribute("baseURI");
        products.get(0).findElement(By.tagName("h2")).getAttribute("textContent");
        products.get(0).findElement(By.tagName("h2")).getAttribute("outerHTML");
        System.out.println( products.get(0).findElement(By.tagName("h2")).getAttribute("innerHTML"));
    }
}

