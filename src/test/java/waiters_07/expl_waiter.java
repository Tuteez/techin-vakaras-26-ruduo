package waiters_07;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class expl_waiter {
    WebDriver driver;
    String correctEmail = "your.email+fakedata79434@gmail.com";
    String incorrectEmail = "ycvbxcvbxcvxbcv4@gmail.com";
    String correctPassword = "fc01WsZ77HP2jn6";
    String incorrectPassword = "ycvbxcvbxcvxbcv4";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();

        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("[href*='account/login']")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void userCanLogin() {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(correctEmail);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(correctPassword);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String expectedH2 = "My Account";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"), expectedH2));
        String actualH2 = driver.findElement(By.cssSelector("h2")).getText();
        Assertions.assertEquals(expectedH2, actualH2);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[normalize-space()='My Account']")));
        boolean isMyAccountDisplayed = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
        Assertions.assertTrue(isMyAccountDisplayed);
    }

    @Test
    void userCantLoginWithIncorrectEmail() {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(incorrectEmail);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(correctPassword);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-danger")));
        String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
        String actualWarning = driver.findElement(By.cssSelector(".alert-danger")).getText();
        Assertions.assertEquals(expectedWarning, actualWarning);
    }

    @Test
    void userCantLoginWithIncorrectPassword() {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(correctEmail);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(incorrectPassword);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
        String actualWarning = driver.findElement(By.cssSelector(".alert-danger")).getText();
        Assertions.assertEquals(expectedWarning, actualWarning);
    }
}
