package assertions_05;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assertJ {
    @Test
    void onlyCss() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        1. open https://opencart.abstracta.us/index.php?route=common/home
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

//          ASSERT: patikrint kaina
        String expectedPrice = "$602.00\nEx Tax: $500.00";
//        Assertions.assertEquals(expectedPrice, driver.findElement(By.cssSelector(".price")).getText());
        String actualPrice = driver.findElement(By.cssSelector(".price")).getText();
        Assertions.assertThat(actualPrice).isEqualTo(expectedPrice);
//        3. keiciam valiuta i eurus (virsuje, kaireje)
        driver.findElement(By.xpath("//span[normalize-space()='Currency']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'€ Euro')]")).click();
//        ASSERT: patikrint kad valiuta pasikeite
String expectedCurrency = "€";
String actualCurrency = driver.findElement(By.cssSelector("#form-currency strong")).getText();
//Assertions.assertEquals(expectedCurrency, actualCurrency);
//        Assertions.assertThat(actualCurrency).isEqualTo(expectedCurrency);
//        5. Pridedam antra preke i krepseli
        driver.findElements(By.xpath("//span[.='Add to Cart']")).get(1).click();
Thread.sleep(2000);
//       patikrinam kad antra preke prideta i krepseli
        String expectedWordToContain = "iPhone";
        String actualMessage = driver.findElement(By.cssSelector(".alert-success")).getText();
        Assertions.assertThat(actualMessage).contains(expectedWordToContain);

        //        7. Uzdarom ta pranesima
        driver.findElement(By.cssSelector(".close")).click();

//        ASSERT: patikrinam pranesimo nesimato
        Assertions.assertThat(
                driver.findElements(By.cssSelector(".alert-success"))
        ).isEmpty();

//        Assertions.assertTrue(
//                driver.findElements(By.cssSelector(".alert-success")).isEmpty()
//        );


//        8. Idedam Canon EOS 5D i wishlist (spaudziam sirdute)
        driver.findElement(By.xpath("//a[text()='Canon EOS 5D']" +
                        "    /ancestor::div[contains(@class,'product-thumb')]" +
                        "    //button[@data-original-title='Add to Wish List']")).
                click();
//        9. pridedam Canon EOS 5D i product comparison
        driver.findElement(By.xpath("//div[contains(@class,'product-thumb')]" +
                        "[.//a[contains(text(),'Canon EOS 5D')]]" +
                        "//button[@data-original-title='Compare this Product']"))
                .click();
//        10. einam i product comparison
        driver.findElement(By.xpath("//a[contains(@href,'product/compare')]")).click();
//        11. Spausdinam product comparison esancios prekes pavadinima
        System.out.println(driver.findElement(By.xpath("//td[text()='Product']/following-sibling::td//strong")).getText());
        driver.quit();
    }
}
