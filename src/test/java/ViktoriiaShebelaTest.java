import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ViktoriiaShebelaTest {


    @Test

    public void doFirstTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test

    public void checkSalesIcon_TC_001 () throws  InterruptedException{

    }

}
