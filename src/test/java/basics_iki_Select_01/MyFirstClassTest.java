package basics_iki_Select_01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstClassTest {
    @Test
    void firstTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

        driver.findElement(By.name("search")).sendKeys("test");

        System.out.println(
                driver.findElements(By.tagName("a")).size()
        );
        driver.quit();
    }

    @Test
    void task(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
//        Isspausdint elemento (id=logo) teksta
        System.out.println(driver.findElement(By.id("logo")).getText());

driver.findElement(By.id("search")).findElement(By.tagName("button")).click();
        driver.quit();

    }

}
