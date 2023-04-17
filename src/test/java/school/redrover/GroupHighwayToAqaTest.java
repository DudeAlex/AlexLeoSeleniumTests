package school.redrover;

import com.github.javafaker.Faker;
import org.checkerframework.checker.i18nformatter.qual.I18nChecksFormat;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GroupHighwayToAqaTest extends BaseTest {

    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(11,12,true,
            true, true);


    @Test
    public void testOpenContactUsPage() {
        getDriver().get(BASE_URL);

        WebElement contactUsLink = getDriver().findElement(By.xpath("//footer/div/ul[@class='footer links']//a[text()='Contact Us']"));
        contactUsLink.click();
        WebElement contactUsPageTitle = getDriver().findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));

        assertEquals(contactUsPageTitle.getText(), "Contact Us");
    }

    @Ignore
    @Test
    public void testErrorMessage() {

        String expectedErrorMessage = "This is a required field.";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://magento.softwaretestingboard.com");

        WebElement scrollByVisibleElement = driver.findElement(By.xpath("//div[@class='footer content']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", scrollByVisibleElement);

        WebElement contactNavItem = driver.findElement(
                By.xpath("//a[@href='https://magento.softwaretestingboard.com/contact/']"));
        contactNavItem.click();

        driver.findElement(By.xpath("//input[@id='name']"))
                .sendKeys("Anna");
        driver.findElement(By.xpath("//input[@id='telephone']"))
                .sendKeys("8995552557");
        driver.findElement(By.xpath("//textarea[@id='comment']"))
                .sendKeys("Thank you for providing such great products and service!");
        driver.findElement(By.xpath("//span[text()='Submit']")).click();

        String actualErrorMessage = driver.findElement(
                By.xpath("//div[@id='email-error']")).getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.quit();
    }

    @Test
    public void MlFirstTest() throws InterruptedException {
        getDriver().get(BASE_URL);

        WebElement textBox = getDriver().findElement(
                By.xpath("//header//a[normalize-space(text())='Create an Account']"));
        textBox.click();

        WebElement text = getDriver().findElement(By.xpath("//span[@data-ui-id = 'page-title-wrapper']"));

        Assert.assertEquals(text.getText(), "Create New Customer Account");

        WebElement firstName =getDriver().findElement(By.xpath("//input[@id = 'firstname']"));
        firstName.sendKeys("Marina");
        WebElement lastName = getDriver().findElement(By.xpath("//input[@id = 'lastname']"));
        lastName.sendKeys("Los");
        WebElement email = getDriver().findElement(By.xpath("//input[@id = 'email_address']"));
        email.sendKeys("test@google.com");
        WebElement password1 = getDriver().findElement(By.xpath("//input[@id = 'password']"));
        password1.sendKeys("123Qwerty+");
        WebElement password2 = getDriver().findElement(By.xpath("//input[@id = 'password-confirmation']"));
        password2.sendKeys("123Qwerty+");
        WebElement submitbutton = getDriver().findElement(
                By.xpath("//button/span[normalize-space(text())='Create an Account']")
        );
        submitbutton.click();

        Thread.sleep(2000);

        WebElement clickHereLink = getDriver().findElement(
                By.xpath("//div/a[normalize-space(text())='click here']")
        );
        clickHereLink.click();

        WebElement forgotPassword = getDriver().findElement(
                By.xpath("//h1/span[normalize-space(text())='Forgot Your Password?']")
        );

        Assert.assertEquals(forgotPassword.getText(), "Forgot Your Password?");
    }

    @Test
    public void testTitle() {
        getDriver().get(BASE_URL);

        Assert.assertEquals(getDriver().getTitle(), "Home Page");
    }

    @Test
    public void testNewLinkAR() {
        String expectedPageTitle = "What's New";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://magento.softwaretestingboard.com/");

        WebDriverWait waitForWhatsNewLink = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForWhatsNewLink.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ui-id-3']")));

        WebElement whatsNewLink = driver.findElement(By.xpath("//a[@id='ui-id-3']"));
        whatsNewLink.click();

        WebElement pageTitle = driver.findElement(By.xpath("//h1[@id='page-title-heading']"));
        String actualPageTitle = pageTitle.getText();

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        driver.quit();
    }

    @Test
    public void testCountShippingOptionsMenTops() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(BASE_URL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-5")));

        WebElement menButton = driver.findElement(By.id("ui-id-5"));
        WebElement topsButton = driver.findElement(By.id("ui-id-17"));

        new Actions(driver).moveToElement(menButton).perform();
        wait.until(ExpectedConditions.visibilityOf(topsButton));
        topsButton.click();

        List<WebElement> listShippingOptions = driver.findElements(By.xpath("//div[@data-role='title']"));

        Assert.assertEquals(listShippingOptions.size(), 13);

        driver.quit();
    }

    @Test
    public void testRequiredFieldMessage() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String expectedMessage = "This is a required field.";

        driver.get(BASE_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement subscribeButton = driver.findElement(By.xpath("//button[@class='action subscribe primary']"));
        js.executeScript("arguments[0].scrollIntoView();", subscribeButton);

        Thread.sleep(2000);

        subscribeButton.click();
        WebElement element = driver.findElement(By.xpath("//div[@id='newsletter-error']"));
        wait.until(ExpectedConditions.visibilityOf(element));

        String actualMessage = element.getText();

        Assert.assertEquals(actualMessage, expectedMessage);

        driver.quit();
    }

    @Test
    public void searchItem() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://magento.softwaretestingboard.com");
        WebElement href = driver.findElement(By.xpath("//div/nav/ul/li[1]"));
        String value = href.getText();
        assertEquals(value, "What's New");
        WebElement href2 = driver.findElement(By.xpath("//div/nav/ul/li[2]"));
        String value1 = href2.getText();
        assertEquals(value1, "Women");
        WebElement href3 = driver.findElement(By.xpath("//div/nav/ul/li[3]"));
        String value2 = href3.getText();
        assertEquals(value2, "Men");
        WebElement href4 = driver.findElement(By.xpath("//div/nav/ul/li [4]"));
        String value3 = href4.getText();
        assertEquals(value3, "Gear");
        WebElement href5 = driver.findElement(By.xpath("//div/nav/ul/li [5]"));
        String value4 = href5.getText();
        assertEquals(value4, "Training");
        WebElement href6 = driver.findElement(By.xpath("//div/nav/ul/li [6]"));
        String value5 = href6.getText();
        assertEquals(value5, "Sale");
        driver.findElement(By.xpath("//div/nav/ul/li [2]")).click();
        String text = driver.getTitle();
        assertEquals(text, "Women");
        driver.findElement(By.xpath("//html/body/div[1]/div[2]/ul/li[1]/a")).click();
        String title = driver.getTitle();
        assertEquals(title, "Home Page");
        driver.quit();
    }

    @Test

    public void testH1TextInWhatIsNew() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(2000);

        WebElement whatIsNew = driver.findElement(By.id("ui-id-3"));
        whatIsNew.click();

        WebElement h1InWhatIsNew = driver.findElement(By.xpath("//h1[@id = 'page-title-heading']/span"));

        Assert.assertEquals(h1InWhatIsNew.getText(), "What's New");

        driver.quit();

    }

    @Test
    public void testNumberOfItemsEqualsProductNumberShownPerPage() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get(BASE_URL);
        Thread.sleep(3000);

        WebElement womenButton = driver.findElement(By.id("ui-id-4"));
        WebElement topsButton = driver.findElement(By.id("ui-id-9"));
        WebElement jacketsButton = driver.findElement(By.id("ui-id-11"));

        new Actions(driver).moveToElement(womenButton).moveToElement(topsButton)
                .moveToElement(jacketsButton).perform();
        jacketsButton.click();

        WebElement expectedNumberOfItems = driver.findElement(By
                .xpath("//span[@class='toolbar-number'][1]"));
        List<WebElement> listOfItemsShownOnPage = driver.findElements(By
                .xpath("//li[@class='item product product-item']"));

        Assert.assertEquals(listOfItemsShownOnPage.size(), Integer.parseInt(expectedNumberOfItems.getText()));
        driver.quit();
    }

    @Test
    void testTrainingMessage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(BASE_URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        Thread.sleep(2000);

        WebElement trainingBar = driver.findElement(By.id("ui-id-7"));
        WebElement trainingLink = driver.findElement(By.id("ui-id-28"));

        new Actions(driver).moveToElement(trainingBar).perform();
        wait.until(ExpectedConditions.visibilityOf(trainingLink));

        trainingLink.click();

        WebElement messageInfo = driver
                .findElement(By
                        .xpath("//div[contains(@class, 'message info empty')]/div"));
        Assert.assertEquals(messageInfo.getText(), "We can't find products matching the selection.");

        driver.quit();

    }

    @Test
    public void testSearching() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(BASE_URL);

        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("watch\n");
        WebElement searchingResult = driver.findElement(By.className("base"));

        Assert.assertEquals(searchingResult.getText(), "Search results for: 'watch'");

        driver.quit();
    }

    @Test
    public void TestYogaShop() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get(BASE_URL);

        WebElement buttonShopNewYoga = driver.findElement(By
                .xpath("//a [@class = \"block-promo home-main\"]//span[text()=\"Shop New Yoga\"]"));
        buttonShopNewYoga.click();

        WebElement searchField = driver.findElement(By.xpath("//input[@id = \"search\"]"));
        searchField.sendKeys("jacket for men");

        WebElement searchText = driver.findElement(By.xpath("//button[@title=\"Search\"]"));
        searchText.click();

        List<WebElement> searchResult = driver.findElements(By
                .xpath("//li[@class =\"item product product-item\"]"));

        String fiveElementText = searchResult.get(5).getText();
        assertTrue(fiveElementText.contains("Jacket"));
        searchResult.get(5).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://magento.softwaretestingboard.com/lando-gym-jacket.html");

        driver.quit();
    }

    @Test
    public void testNumberOfItemsShownOnPageChanged() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(BASE_URL);
        Thread.sleep(2000);
        WebElement womenButton = driver.findElement(By.id("ui-id-4"));
        WebElement topsButton = driver.findElement(By.id("ui-id-9"));

        actions.moveToElement(womenButton).moveToElement(topsButton).perform();
        topsButton.click();

        WebElement expectedNumberOfItems12 = driver.findElement(By
                .xpath("//div[@class ='toolbar toolbar-products'][2]/div[3]/div/select/option[@value='12']"));
        List<WebElement> listOfItemsShownOnPage12 = driver.findElements(By
                .xpath("//li[@class='item product product-item']"));

       /* Checking the number of items shown on page equals the number depicted in the "show per page" block
        in the bottom right corner of the page */

        Assert.assertEquals(listOfItemsShownOnPage12.size(), Integer.parseInt(expectedNumberOfItems12.getText()));
        expectedNumberOfItems12.click();

        // Selecting number 24 in the "show per page" block so that 24 items to be shown on the page

        WebElement expectedNumberOfItems24 = driver.findElement(By
                .xpath("//div[@class ='toolbar toolbar-products'][2]/div[3]/div/select/option[@value='24']"));
        wait.until(ExpectedConditions.elementToBeClickable(expectedNumberOfItems24)).click();

        List<WebElement> listOfItemsShownOnPage24 = driver.findElements(By
                .xpath("//li[@class='item product product-item']"));

        WebElement expectedNumberOfItems24_ = driver.findElement(By
                .xpath("//div[@class ='toolbar toolbar-products'][2]/div[3]/div/select/option[@value='24']"));

        // Checking 24 items are shown on page as has been selected in the "show per page" block
        Assert.assertEquals(listOfItemsShownOnPage24.size(), Integer.parseInt(expectedNumberOfItems24_.getText()));

        driver.quit();
    }

    @Test
    public void testBlockPromo() throws InterruptedException {
        getDriver().get(BASE_URL);

        WebElement blockPromo = getDriver().findElement(By.xpath("//span[@class='action more button']"));
        blockPromo.click();
        Thread.sleep(2000);

        String title = getDriver().findElement(By.xpath("//span[@class='base']")).getText();

        Assert.assertEquals(title, "New Luma Yoga Collection");
    }

    @Test
    public void testCreateAnAccountWithFacker() throws InterruptedException {
        getDriver().get(BASE_URL);

        WebElement createAnAccountHref = getDriver().findElement(By.linkText("Create an Account"));
        createAnAccountHref.click();
        String value = getDriver().getTitle();

        Assert.assertEquals(value, "Create New Customer Account");
        Thread.sleep(2000);
        getDriver().findElement(By.id("firstname")).sendKeys(firstName);
        getDriver().findElement(By.id("lastname")).sendKeys(lastName);
        getDriver().findElement(By.id("email_address")).sendKeys(email);
        getDriver().findElement(By.id("password")).sendKeys(password);
        getDriver().findElement(By.id("password-confirmation")).sendKeys(password);
        WebElement buttonForCreationAccout = getDriver().findElement(By.xpath("//form[@id='form-validate']//button/span[text()='Create an Account']"));
        buttonForCreationAccout.click();
        Thread.sleep(2000);
        WebElement titleOfSucessCreationAccountMessage = getDriver().findElement(By.xpath("//div[@class='message-success success message']"));;

        Assert.assertEquals(titleOfSucessCreationAccountMessage.getText(), "Thank you for registering with Main Website Store.");
    }

    @Ignore
    @Test
    public void testSubscription() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(BASE_URL);
        char[] prefix = new char[6];
        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = (char) (Math.random() * (122 - 97) + 97);
        }
        WebElement emailInput = driver.findElement(By.cssSelector("#newsletter"));
        String emailPostfix = "@mail.ru";
        String emailPrefix = new String(prefix);
        String email = emailPrefix.concat(emailPostfix);
        emailInput.sendKeys(email);
        WebElement submitButton = driver.findElement(By
                .xpath("//button[@title = 'Subscribe']"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement message = driver.findElement(By
                .xpath("//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(message.getText(), "Thank you for your subscription.");
        emailInput = driver.findElement(By.xpath("//input[@placeholder = 'Enter your email address']"));
        emailInput.sendKeys(email);
        submitButton = driver.findElement(By
                .xpath("//button[@title = 'Subscribe']"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement errorMessage = driver.findElement(By
                .xpath("//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(errorMessage.getText(), "This email address is already subscribed.");
        driver.quit();
    }

    @Test
    public void testCheckEmptyCartText() throws InterruptedException {
        getDriver().get(BASE_URL);

        Thread.sleep(2000);
        WebElement cartIcon = getDriver().findElement(By.xpath("//header//a[contains(@href, 'cart')]"));
        cartIcon.click();
        WebElement cartDropDownDialog = getDriver().findElement(
                By.xpath("//div[@id='ui-id-1']//div[@class='block-content']//strong"));

        assertEquals(cartDropDownDialog.getText(),"You have no items in your shopping cart.");
    }

    @Test
    public void testNumOfItemsInCartCounter() throws InterruptedException {
        getDriver().get(BASE_URL);

        Thread.sleep(3000);
        WebElement womenLink = getDriver().findElement(By.xpath("//a[@id='ui-id-4']"));
        womenLink.click();
        WebElement topsLink = getDriver().findElement(By.xpath("//dl[@class='options']//a[contains(text(), 'Tops')]"));
        topsLink.click();
        WebElement firstItemInListLink = getDriver().findElement(By.xpath("//ol[@class='products list items product-items']/li//a"));
        firstItemInListLink.click();

        Thread.sleep(3000);
        WebElement itemSize = getDriver().findElement(By.xpath("//div[@class='swatch-option text']"));
        itemSize.click();
        WebElement itemColor = getDriver().findElement(By.xpath("//div[@class='swatch-option color']"));
        itemColor.click();
        WebElement addToCartButton = getDriver().findElement(By.id("product-addtocart-button"));
        addToCartButton.click();

        Thread.sleep(3000);
        WebElement numOfItemsInCart = getDriver().findElement(By.xpath("//div[@data-block='minicart']//span[@class='counter-number']"));

        assertEquals(numOfItemsInCart.getText(), "1");
    }
}
