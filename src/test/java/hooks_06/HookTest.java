package hooks_06;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HookTest {
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
    void userCanLogin() throws InterruptedException {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(correctEmail);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(correctPassword);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(1000);

        String expectedH2 = "My Account";
        String actualH2 = driver.findElement(By.cssSelector("h2")).getText();
        Assertions.assertEquals(expectedH2, actualH2);
    }

    @Test
    void userCantLoginWithIncorrectEmail() throws InterruptedException {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(incorrectEmail);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(correctPassword);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(1000);

        String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
        String actualWarning = driver.findElement(By.cssSelector(".alert-danger")).getText();
        Assertions.assertEquals(expectedWarning, actualWarning);
    }

    @Test
    void userCantLoginWithIncorrectPassword() throws InterruptedException {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(correctEmail);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(incorrectPassword);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(1000);

        String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
        String actualWarning = driver.findElement(By.cssSelector(".alert-danger")).getText();
        Assertions.assertEquals(expectedWarning, actualWarning);
    }
}
