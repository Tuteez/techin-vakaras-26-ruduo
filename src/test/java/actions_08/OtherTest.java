package actions_08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Paths;

public class OtherTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void testClick() {
        WebElement input = driver.findElement(By.cssSelector("#file-upload"));
        String filePath = Paths.get("src/test/java/actions_08/note").toAbsolutePath().toString();
        input.sendKeys(filePath);

        driver.quit();
    }
}
