package assertions_05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class aaaTEST {
    @Test
    void aaaTest(){

        String a = "a";
        String b = "b";
        String aa = "a";
        assertEquals(a,aa);


//        booolean
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
boolean isLogoDisplayed = driver.findElement(By.xpath("//a[normalize-space()='Your Store']")).isDisplayed();
//        Assertions.assertEquals(true,true);
        Assertions.assertTrue(false);


        String city = "aaa";
        String street = "str";
        String number = "500";
        assertAll("Should return address of Oracle's headquarter",
                () -> assertEquals("Redwood Shores",city),
                () -> assertEquals("Oracle Parkway", street),
                () -> assertEquals("500", number)
        );

    }
}
