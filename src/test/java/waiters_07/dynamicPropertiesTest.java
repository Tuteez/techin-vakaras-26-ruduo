package waiters_07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dynamicPropertiesTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void testDynamicProperties() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#enableAfter")));
    }

    @Test
    public void testDynamicProperties2() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(
                        By.cssSelector("#colorChange"),
                        "class",
                        "text-danger"
                ));
    }

    @Test
    public void testDynamicProperties3() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visibleAfter")));
    }

}
