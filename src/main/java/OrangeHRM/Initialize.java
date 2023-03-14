package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Timespan;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class Initialize {
    WebDriver d;
   WebDriverWait wait;
    @BeforeTest()
    public void Initialization() throws Exception {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver(options);
        wait = new WebDriverWait(d,Duration.ofSeconds(30));
        d.manage().window().maximize();
    }
    @AfterTest
    public void TearDown()
    {
        d.quit();
    }

}
