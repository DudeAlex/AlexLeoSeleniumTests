package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class AlexLeoEpicGroupTest {
    @Test
    public void titleOfTheHomePageCheckedTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        WebElement icon = driver.findElement(By.xpath("//span[@class='onsale']"));
        Assert.assertEquals(icon.getText(), "Sale!");
        driver.quit();
    }


    @Test
    public void verifySaleSTas_TC_001_04() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com");
        driver.manage().window().maximize();
        WebElement saleSign = driver.findElement(By.className("onsale"));
        Assert.assertEquals(saleSign.getText(), "Sale!");

        driver.quit();
    }

    @Test
    public void buttonOpened() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com/");
        String url = "https://askomdch.com/store";

        driver.findElement(By.cssSelector("div.wp-block-button>a[href=\"/store\"]")).click();
        Assert.assertEquals(url, "https://askomdch.com/store");
        driver.quit();
    }

    @Test
    public void colourTest_TC_007_23() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://askomdch.com/");
        driver.findElement(By.cssSelector("a[href*='men']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("button[value='Search']")).
                getCssValue("background-color"), "rgba(49, 151, 214, 1)");
        driver.quit();
    }

    @Test
    public void testAssertDiscountInfo() {

        final String DISCOUNT_INFO = "25% OFF On all products";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement textDiscount = driver.findElement(By.xpath("//h3[text()='25% OFF On all products']"));

        Assert.assertEquals(textDiscount.getText(), DISCOUNT_INFO);

        driver.quit();
    }

    @Test

    public void checkDiscount() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://askomdch.com/");
        WebElement discount = driver.findElement(By.xpath("//h3[contains(text(), \"25% OFF \")]"));
        Assert.assertEquals(discount.getText(), "25% OFF On all products");
        driver.quit();
    }

    @Test
    public void clickAccountButtonTest() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//li[@id='menu-item-1237']/a")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");
        driver.quit();
    }

    @Test
    public void productsNumberTest_TC_006_23() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.findElement(By.cssSelector("ul.products.columns-5")).
                findElements(By.tagName("li")).size(), 5);
        driver.quit();
    }

    @Test
    public void currencyTest_TC_002_23() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://askomdch.com/");
        for (WebElement element : driver.findElements(By.cssSelector("span[class*='currencySymbol']"))) {
            Assert.assertEquals(element.getText(), "$");
        }
        driver.quit();
    }

    @Test
    public void VerifyTheLoginPage_TC() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        driver.findElement(By.xpath("//span[@class='onsale']")).isDisplayed();
        WebElement shopNowButton = driver.findElement(By.xpath("//a[@class='wp-block-button__link']"));
        shopNowButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");
        driver.quit();

    }

    @Test
    public void MikeBTest() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));


        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.findElement(By.xpath("//a[@class=\"wp-block-button__link\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");


    }

    @Test
    public void testFindGitHubEl() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://www.jenkins.io/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.jenkins.io/");

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"sponsorsblock\"]/div[1]/ul/li[6]/a/img"))
                .isDisplayed());
    }

    @Test
    public void test_006() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        String textBox = driver.findElement(By.xpath("//h2[@class='has-text-align-center']")).getText();

        Assert.assertEquals(textBox, "Featured Products");
        List<WebElement> products = driver.findElements(By.className("type-product"));
        Assert.assertEquals(products.size(), 5);
        driver.quit();

    }

    @Test
    public void Test_TC_001_33() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        try {
            driver.get("https://askomdch.com/");
            WebElement featuredProducts = driver
                    .findElement(By.xpath("//*[contains(text(),'Featured Products')]"));
            List<WebElement> saleProducts = featuredProducts
                    .findElements(By.xpath("//li[contains(@class, 'ast-article-single')]" +
                            "[count(.//span[contains(@class, 'woocommerce-Price-currencySymbol')]) > 1]"));
            for (WebElement saleProduct : saleProducts) {
                assertTrue(saleProduct.findElement(By.cssSelector("span.onsale"))
                        .isDisplayed(), "Sale icon not found on a sale product: " + saleProduct.getText());
            }
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }


    @Test
    public void TC_002_33_ArtemT_verifyShopNowLink() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        try {
            driver.get("https://askomdch.com/");
            driver.findElement(By.xpath("//a[@class='wp-block-button__link' and text()='Shop Now']"))
                    .click();
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://askomdch.com/store");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void TC003_33_ArtemT_verifyFindMoreLink() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        try {
            driver.get("https://askomdch.com/");
            driver.findElements(By.cssSelector("a.wp-block-button__link")).get(1).click();
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://askomdch.com/contact-us/");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void verifyTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://askomdch.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebElement saleSign = driver.findElement(By.className("onsale"));
        Assert.assertEquals(saleSign.getText(), "Sale!");

        driver.quit();
    }

    @Test
    public void test_TC_003_01() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://askomdch.com");
        WebElement text = driver.findElement(By.xpath("//h3[contains(text(), '25%')]"));
        Assert.assertEquals(text.getText(), "25% OFF On all products");

        driver.quit();
    }

    @Test
    public void dollarSignTest() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price']"));
        for (WebElement price : prices) {
            Assert.assertTrue(price.getText().contains("$"));
        }
        driver.quit();
    }

    @Test
    public void test_TC_006_01() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://askomdch.com");
        List<WebElement> list = driver.findElements(By.className("astra-shop-thumbnail-wrap"));
        Assert.assertEquals(list.size(), 5);

        driver.quit();
    }


    @Test
    public void saleIconVerificationTest_TC_001_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        WebElement featuredProductsElement = driver.findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//div[@class='astra-shop-thumbnail-wrap']/parent::li"));
        for (WebElement featuredProduct : featuredProducts) {
            try {
                String value = featuredProduct.findElement(By.xpath("//del[@aria-hidden='true']"))
                        .getAttribute("aria-hidden");
                if (value.equals("true")) {
                    String sale = featuredProduct.findElement(By.xpath("//span[@class='onsale']")).getText();
                    Assert.assertEquals(sale, "Sale!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @Test
    public void dollarSignVerificationTest_TC_002_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        WebElement featuredProductsElement = driver.findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//span[@class='woocommerce-Price-currencySymbol']"));
        for (WebElement featuredProduct : featuredProducts) {
            String sign = featuredProduct.getText();
            Assert.assertEquals(sign, "$");
        }
    }

    @Test
    public void discountMessageVerificationTest_TC_003_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        String actualText = driver.findElement(By.xpath("//h3[@class='has-text-align-center has-white-color " +
                "has-text-color has-medium-font-size']")).getText();

        String expectedText = "25% OFF On all products";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void loginPageVerificationTest_TC_004_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/account/' and text()='Account']")).click();

        String url = "https://askomdch.com/account/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void storePageVerificationTest_TC_005_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/store/' and text()='Store']")).click();

        String url = "https://askomdch.com/store/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void numberOfProductsVerificationTest_TC_006_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        WebElement featuredProductsElement = driver.findElement(By.xpath("//h2[@class='has-text-align-center']"));
        List<WebElement> featuredProducts = featuredProductsElement.findElements(By.xpath(
                "//div[@class='astra-shop-thumbnail-wrap']/parent::li"));
        Assert.assertEquals(featuredProducts.size(), 5);
    }

    @Test
    public void numberOfProductsVerificationTest_TC_007_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/product-category/men/']")).click();
        WebElement button = driver.findElement(By.xpath("//button[@type='submit' and @value='Search']"));

        String expectedColor = "rgba(49, 151, 214, 1)";
        Assert.assertEquals(button.getCssValue("background-color"), expectedColor);
    }

    @Test
    public void findMorePageVerificationTest_TC_008_24() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://askomdch.com/");
        driver.findElement(By.xpath("//a[@href='https://askomdch.com/contact-us/' and text()='Find More']")).click();
        String actaulPage = driver.getTitle().substring(0, 10);
        String expectedPage = "Contact Us";
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://askomdch.com/contact-us/";
        Assert.assertEquals(actaulPage, expectedPage);
        Assert.assertEquals(actualLink, expectedLink);
    }


  @Test
  public void testMenuBar() throws InterruptedException {

      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
      WebDriver driver = new ChromeDriver(chromeOptions);
      driver.get("https://askomdch.com/");
      Thread.sleep(3000);
      WebElement menu = driver.findElement(By.xpath("//ul[@id='ast-hf-menu-1']"));
      Thread.sleep(3000);
      List<WebElement> products = menu.findElements(By.tagName("li"));
      Assert.assertEquals(products.size(), 8);
      driver.quit();

  }

    @Test
    public void saleTest_TC_001_23_PetroMatsiura() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://askomdch.com/");
        for(WebElement element : driver.findElements(By.cssSelector("span[class='onsale']"))){
            Assert.assertEquals(element.getText(), "Sale!");
        }
        driver.quit();
    }

    @Test
    public void discountTest_TC_003_23_PetroMatsiura() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://askomdch.com/");
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[class*='medium-font-size']")).
                getText(), "25% OFF On all products");
        driver.quit();
    }


    @Test
    public void test_TC_005_01() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://askomdch.com");
        driver.findElement(By.cssSelector("a[href='/store']")).click();
        WebElement store = driver.findElement(By.xpath("//header[contains(@class, 'woocommerce-products-header')]//following::h1"));
        Assert.assertEquals(store.getText(), "Store");

        driver.quit();
    }

}
