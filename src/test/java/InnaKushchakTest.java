import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.List;
@Ignore
public class InnaKushchakTest extends BaseTest {
    @Test
    public void testVerifySaleIcon() {

        WebElement icon = getDriver().findElement(By.xpath("//span[@class='onsale']"));
        Assert.assertEquals(icon.getText(), "Sale!");
    }

    @Test
    public void testValidate$SignIsPresent() {

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
    public void testNumberOfElementInFutureProducts() {

        WebElement featureProducts=getDriver().findElement(By.xpath("//div[@class='wp-block-group alignfull']//ul"));
        List<WebElement> products=featureProducts.findElements(By.tagName("li"));
        for (WebElement elem:products) {
         List<WebElement> x= elem.findElements(By.tagName("h2"));
            System.out.println(x.size());
        }
    }
    
    @Test
    public void testWebDriverSearchBlueShoes() {

        WebElement featureProducts = getDriver().findElement(By.xpath("//div[@class='wp-block-group alignfull']//ul"));
        List<WebElement> products = featureProducts.findElements(By.tagName("li"));
        products.get(0).getAttribute("baseURI");
        products.get(0).findElement(By.tagName("h2")).getAttribute("textContent");
        products.get(0).findElement(By.tagName("h2")).getAttribute("outerHTML");

        Assert.assertEquals(products.get(0).findElement(By.tagName("h2")).getAttribute("innerHTML"), "Blue Shoes");
    }
    @Test
    public void testFindInvisible(){

        getDriver().get("https://jsbin.com/saqoca/2/edit?html,output");
        WebElement frame=getDriver().findElement(By.xpath("//iframe[@class='stretch']"));
        getDriver().switchTo().frame(frame);
        frame = getDriver().findElement(By.xpath("//div[@id = 'sandbox-wrapper']/iframe"));
        getDriver().switchTo().frame(frame);
        String invisible = getDriver().findElement(By.xpath("//h1")).getText();

        Assert.assertEquals(invisible, "Invisibles");
    }
    @Test
    public void testInvis(){

        getDriver().get("https://jsbin.com/saqoca/2/edit?html,output");
        WebElement frame=getDriver().findElement(By.xpath("//iframe[@class='stretch']"));
        getDriver().switchTo().frame(frame);
        frame = getDriver().findElement(By.name("JS Bin Output "));
        getDriver().switchTo().frame(frame);
        getDriver().findElement(By.xpath("//div/span[text()='Almost transparent text']"));
        
    }
    @Test
    public void testWomenPage7ElementsIsPresent(){
        getDriver().findElement(By.xpath("//a[@href='https://askomdch.com/product-category/women/']")).click();
        WebElement women=getDriver().findElement(By.xpath("//div[@class='ast-woocommerce-container']"));
        List<WebElement> products=women.findElements(By.tagName("li"));

        Assert.assertEquals(products.size(),7);
    }
    @Test
    public void testSortByPrice(){
        getDriver().findElement(By.xpath("//*[@id=\"post-61\"]/div/div[1]/div/div/div/div/div[1]/a")).click();
        WebElement obj=getDriver().findElement(By.cssSelector("select[name='orderby']"));
        



    }
}



