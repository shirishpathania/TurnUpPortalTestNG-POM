package Pages;

import Utilities.Wait;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    // Page Object Model
    By username = By.id("UserName");
    By password = By.id("Password");
    By loginButton = By.xpath("//*[@id='loginForm']/form/div[3]/input[1]");

    public void LoginSteps(WebDriver driver) {

        // Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit Wait
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        // maximise window
        driver.manage().window().maximize();

        // launch turn up portal
        driver.navigate().to("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f");

        try {
            // identify username textbox and enter valid username
            Wait.WaitToBeClickable(driver, "id", "UserName", 10);
//            WebElement userName = driver.findElement(By.id("UserName"));
//            userName.sendKeys("hari");
            driver.findElement(username).sendKeys("hari");

            // identify password textbox and enter valid password
//            WebElement password = driver.findElement(By.id("Password"));
//            password.sendKeys("123123");
            driver.findElement(password).sendKeys("123123");

            // identify login button and click
//            WebElement login = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
//            login.click();
            driver.findElement(loginButton).click();

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Hello hari!')]")));
            Wait.WaitToBeVisible(driver, "xpath", "//a[contains(text(),'Hello hari!')]", 20);

        } catch (Exception ex) {
            Assert.isTrue(1 == 0, "TurnUp portal page did not launch");
        }

    }
}
