package hooks_06;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HookTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Order(1)
    @Test
    void userCanLogin() {

    }

    @Test
    void userCantLoginWithIncorrectUsername() {

    }

    @Test
    void userCantLoginWithIncorrectPassword() {

    }
}
