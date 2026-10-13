package env.setup_01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstClassTest {
    @Test
    void firstTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }

    @Test
    void secondTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
}
