package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.time.Duration;

public class GroupJavaExplorersTest extends BaseTest {

    @Test
    public void testTrelloTitle() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        String url = "https://trello.com/";
        String expTitle = "Manage Your Team’s Projects From Anywhere | Trello";

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        Assert.assertEquals(driver.getTitle(), expTitle);

        driver.quit();
    }

    @Test
    public void vhodTextOnAuthPageTest() throws InterruptedException {

        //проверка того, что на окошке со входом над полями Логина и пасса есть слово Вход
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        //"--remote-allow-origins=*", "--headless" --- params for server

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.21vek.by/");             //проходим на сайт

        Thread.sleep(1000);

        WebElement buttonCookie = driver.findElement(    //прошли выплывашку с куки
                By.xpath("//button[@class='Button-module__button Button-module__blue-primary']"));
        buttonCookie.click();

        Thread.sleep(1000);

        WebElement buttonAccount = driver.findElement(   // нажали на Аккаунт
                By.xpath("//button[@class='styles_userToolsToggler__imcSl']"));
        buttonAccount.click();

        Thread.sleep(1000);

        WebElement buttonVoiti = driver.findElement(   // нажали на Войти
                By.xpath("//button[@data-testid='loginButton']"));
        buttonVoiti.click();

        Thread.sleep(1000);

        WebElement textVhod = driver.findElement(   // нашли текст вверху, в центре, где должно быть ВХОД
                By.xpath("//h5[@class='style_formTitle__hRNRz']"));
        Assert.assertEquals(textVhod.getText(), "Вход");

        driver.quit();
    }

    @Test
    public void testEquilateralTriangle() {
        int triangleSize = 5;
        final String expectedResult = "Equilateral";

        getDriver().get("https://testpages.herokuapp.com/styled/apps/triangle/triangle001.html");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement inputSize1 =  getDriver().findElement(By.id("side1"));
        inputSize1.click();
        inputSize1.sendKeys(String.valueOf(triangleSize));
        WebElement inputSize2 =  getDriver().findElement(By.id("side2"));
        inputSize2.click();
        inputSize2.sendKeys(String.valueOf(triangleSize));
        WebElement inputSize3 =  getDriver().findElement(By.id("side3"));
        inputSize3.click();
        inputSize3.sendKeys(String.valueOf(triangleSize));
        WebElement button =  getDriver().findElement(By.id("identify-triangle-action"));
        button.sendKeys(Keys.ENTER);

        WebElement actualResult =  getDriver().findElement(By.id("triangle-type"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
    }
}
