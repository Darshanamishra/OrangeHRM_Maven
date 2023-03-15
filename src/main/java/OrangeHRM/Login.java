package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login extends Initialize {
    //Login Module with Positive/Negative TestCases
    @Test(priority = 6)
    public void ValidLogin() throws Exception {
        d.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        d.findElement(By.name("username")).sendKeys("Admin");
        d.findElement(By.name("password")).sendKeys("admin123", Keys.ENTER);
        Assert.assertEquals(d.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        System.out.println("Login successfully");
    }

    @Test(priority = 1)
    public void InvalidUsernameLogin() throws Exception {
        d.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        d.findElement(By.name("username")).sendKeys("Admi");
        d.findElement(By.name("password")).sendKeys("admin123", Keys.ENTER);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(d.findElement(By.cssSelector(".oxd-alert-content-text")).isEnabled());
        System.out.println("Invalid Username");
    }

    @Test(priority = 2)
    public void InvalidPassLogin() throws Exception {
        d.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        d.findElement(By.name("username")).sendKeys("Admin");
        d.findElement(By.name("password")).sendKeys("admin", Keys.ENTER);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(d.findElement(By.cssSelector(".oxd-alert-content-text")).isEnabled());
        System.out.println("Invalid Password");
    }

    @Test(priority = 3)
    public void InvalidUsernamePassLogin() throws Exception {
        d.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        d.findElement(By.name("username")).sendKeys("Admi");
        d.findElement(By.name("password")).sendKeys("admi", Keys.ENTER);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(d.findElement(By.cssSelector(".oxd-alert-content-text")).isEnabled());
        System.out.println("Invalid Username and Password");
    }

    @Test(priority = 4)
    public void InvalidLoginEmptyUsername() throws Exception {
        d.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        d.findElement(By.name("password")).sendKeys("admin123", Keys.ENTER);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(d.findElement(By.xpath("//form[@class='oxd-form']/div[1]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).isEnabled());
        System.out.println("Username empty");
    }

    @Test(priority = 5)
    public void InvalidLoginEmptyPass() throws Exception {
        d.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        d.findElement(By.name("username")).sendKeys("Admin", Keys.ENTER);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(d.findElement(By.xpath("//form[@class='oxd-form']/div[2]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).isEnabled());
        System.out.println("Password empty");
    }
}
