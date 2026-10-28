package actions_08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SomeTasks {
    @Test
    public void someTasks(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".figure"))).perform();
        driver.findElement(By.partialLinkText("profile")).click();

        Assertions.assertEquals("Not Found", driver.findElement(By.cssSelector("h1")).getText());
    }
}
