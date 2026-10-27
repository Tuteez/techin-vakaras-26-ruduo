package waiters_07;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Impl_waiter {
    WebDriver driver;
    String correctEmail = "your.email+fakedata79434@gmail.com";
    String incorrectEmail = "ycvbxcvbxcvxbcv4@gmail.com";
    String correctPassword = "fc01WsZ77HP2jn6";
    String incorrectPassword = "ycvbxcvbxcvxbcv4";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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

//        String expectedH2 = "My Account";
//        String actualH2 = driver.findElement(By.cssSelector("h2")).getText();
//        Assertions.assertEquals(expectedH2, actualH2);

        boolean isMyAccountDisplayed = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
        Assertions.assertTrue(isMyAccountDisplayed);
    }

    @Test
    void userCantLoginWithIncorrectEmail() {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(incorrectEmail);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(correctPassword);
        driver.findElement(By.cssSelector("[type='submit']")).click();

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
