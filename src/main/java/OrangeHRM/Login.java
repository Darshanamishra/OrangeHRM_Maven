package OrangeHRM;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import java.time.Duration;

public class Login extends Initialize {

    @Deprecated
    @Test(priority = 1)
    public void login() throws Exception{
        d.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        d.findElement(By.name("username")).sendKeys("Admin");
        d.findElement(By.name("password")).sendKeys("admin123");
        d.findElement(By.name("password")).sendKeys(Keys.ENTER);
        d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
