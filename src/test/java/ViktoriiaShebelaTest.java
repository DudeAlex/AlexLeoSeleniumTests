import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.List;

public class ViktoriiaShebelaTest  {

      @Test

      public void testVerifyBaggroundColorSearch(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://askomdch.com");

       WebElement menButton = driver.findElement(By.xpath("//*[@id='menu-item-1228']/a"));




      }

  @Test
  public void testExplicitWait(){
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    WebElement landscapeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));

    Assert.assertTrue(landscapeElement.getAttribute("src").contains("landscape"));

    //driver.findElement(By.id("landscape"));
    driver.quit();
  }
  @Test
  public void testExplicitWaitLambda(){
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    WebElement landscapeElement = wait.until(d -> d.findElement(By.id("landscape")));

    Assert.assertTrue(landscapeElement.getAttribute("src").contains("landscape"));

    //driver.findElement(By.id("landscape"));
    driver.quit();
  }
  @Test

  public void testSlowCalculator () {
    WebDriver driver = new ChromeDriver();
    driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.findElement(By.xpath("//span[contains(text(),'2')]")).click();
    driver.findElement(By.xpath("//span[(text()='+')]")).click();
    driver.findElement(By.xpath("//*[(text()='3')]")).click();
    driver.findElement(By.xpath("//*[(text()='=')]")).click();
    boolean x = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class ='screen']"), "5"));

    Assert.assertTrue(x);
    driver.quit();
  }
       @Test

       public void testFrameInvisibleElements() {

         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
         driver.get("https://jsbin.com/saqoca/2/edit?html,output");

         WebElement frame = driver.findElement(By.xpath("//iframe[@class = 'stretch']"));
         driver.switchTo().frame(frame);
         frame = driver.findElement(By.xpath("//div[@id = 'sandbox-wrapper']/iframe"));
         driver.switchTo().frame(frame);
         String invisible = driver.findElement(By.xpath("//h1")).getText();

         Assert.assertEquals(invisible, "Invisibles");

         driver.quit();

       }

  @Test

  public void testFrameInvisible() {

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.get("https://jsbin.com/saqoca/2/edit?html,output");

    WebElement frame = driver.findElement(By.xpath("//iframe[@class = 'stretch']"));
    driver.switchTo().frame(frame);
    frame = driver.findElement(By.name("JS Bin Output "));
    //frame = driver.findElement(By.xpath("//div[@id = 'sandbox-wrapper']/iframe"));
    driver.switchTo().frame(frame);
    String invisible = driver.findElement(By.xpath("//h1")).getText();

    Assert.assertEquals(invisible, "Invisibles");

    driver.quit();

  }

  @Test
  public void testMihay(){

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.get("https://jsbin.com/saqoca/2/edit?html,output");

    WebElement frame = driver.findElement(By.cssSelector("iframe[class='stretch']"));
    driver.switchTo().frame(frame);

    frame = driver.findElement(By.xpath("//div[@id='sandbox-wrapper']/iframe"));
    driver.switchTo().frame(frame);

    boolean check = driver.findElement(By.xpath("//div/span[text()='Almost transparent text']")).isDisplayed();

    Assert.assertEquals(check,false);

    driver.quit();
  }























//  private WebDriver driver;
//
//  @Test
//  public void testFirstn() {
//    Assert.assertEquals(getDriver().getTitle(), "AskOmDch – Become a Selenium automation expert!");
//  }
//
//  @Test
//  public void testWebDriver() {
//    WebElement featuredProducts = getDriver()
//            .findElement(By.xpath("//div[@class='wp-block-group alignfull']//ul"));
//    List<WebElement> prducts = featuredProducts.findElements(By.tagName("li"));
//    System.out.println(prducts.size());
//  }
////  @Test
////  public void testSelenium() {
//////    driver.manage().window().maximize();
////   // driver.get("https://askomdch.com/store/");
//////
//////    WebElement area = getDriver().findElement(By.id("woocommerce_top_rated_products-3"));
//////    List<WebElement> dollarSign = area.findElements(By.className("woocommerce-Price-currencySymbol"));
//////
//////    System.out.println(dollarSign.size());
//////  }
}


