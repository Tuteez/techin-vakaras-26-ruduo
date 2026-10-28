package actions_08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void testClick() {
        Actions actions = new Actions(driver);
        WebElement buttonToWorkWith = driver.findElement(By.cssSelector("#doubleClickBtn"));
        actions.doubleClick(buttonToWorkWith).perform();
    }
}
