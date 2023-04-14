import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class InnaKushchakTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com/");
    }

    @AfterMethod

    public void afterMethod() {

        driver.quit();
    }

    @Test
    public void testVerifySaleIcon() {
        WebElement icon = driver.findElement(By.xpath("//span[@class='onsale']"));
        Assert.assertEquals(icon.getText(), "Sale!");
    }

    @Test
    public void validate$SignIsPresent() {
        WebElement sign = driver.findElement(By.xpath("//span[@class='woocommerce-Price-currencySymbol']"));
        Assert.assertEquals(sign.getText(), "$");
    }

    @Test
    public void offOnAllProducts() {

        String message = driver.findElement(By.xpath("//h3[text()='25% OFF On all products']")).getText();
        Assert.assertEquals(message, "25% OFF On all products");
    }

    @Test
    public void verifyingLogInButton() {
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/account/']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
    }

    @Test
    public void verifyingShopNowButton() {
        driver.findElement(By.xpath("//a[text()='Shop Now']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
    }

    @Test
    public void verify5ProductsDisplayed() {
        Assert.assertEquals(driver.findElement(By.cssSelector("ul.products.columns-5")).findElements(By.tagName("li")).size(), 5);
    }

    @Test
    public void manSearchButtonColorVerification() {
        driver.findElement(By.cssSelector("li[id='menu-item-1228']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//button[@value='Search']")).getCssValue("background-color"), "rgba(49, 151, 214, 1)");
    }

    @Test
    public void contactUsButtonVerification() {
        driver.findElement(By.cssSelector("div[class='wp-block-button is-style-fill']")).click();
        Assert.assertEquals(driver.getTitle(), "Contact Us – AskOmDch");
    }
}

