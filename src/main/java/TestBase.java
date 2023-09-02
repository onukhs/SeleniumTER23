import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();

        System.out.println("INFO: Browser is setup");
    }

    @After
    public void shutDown(){
        driver.close();
        driver.quit();

        System.out.println("INFO: Browser is down");
    }
}
