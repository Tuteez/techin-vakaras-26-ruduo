package assertions_05;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class junit {
    @Test
    void onlyCss() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        1. open https://opencart.abstracta.us/index.php?route=common/home
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
//        2. Atspausdina pirmos prekes kaina
        System.out.println(
                driver.findElement(By.cssSelector(".price")).getText()
        );
//          ASSERT: patikrint kaina
        String expectedPrice = "$602.00\nEx Tax: $500.00";
        Assertions.assertEquals(expectedPrice, driver.findElement(By.cssSelector(".price")).getText());
//        3. keiciam valiuta i eurus (virsuje, kaireje)
        driver.findElement(By.xpath("//span[normalize-space()='Currency']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'€ Euro')]")).click();
//        ASSERT: patikrint kad valiuta pasikeite
        String expectedCurrency = "€";
        String actualCurrency = driver.findElement(By.cssSelector("#form-currency strong")).getText();
        Assertions.assertEquals(expectedCurrency, actualCurrency);
//        4. Atspausdina pirmos prekes kaina
        System.out.println(
                driver.findElement(By.cssSelector(".price")).getText()
        );
//        5. Pridedam antra preke i krepseli
        driver.findElements(By.xpath("//span[.='Add to Cart']")).get(1).click();
//        6. Atspausdinam zalia pranesima kad preke ideta i krepseli
        System.out.println(
                driver.findElement(By.cssSelector(".alert-success")).getText()
        );
        //        7. Uzdarom ta pranesima
        driver.findElement(By.cssSelector(".close")).click();
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

    @Test
    void onlyCss2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

        driver.findElement(By.xpath("//span[normalize-space()='Currency']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'€ Euro')]")).click();


//        ASSERT: patikrint kad valiuta pasikeite
        String expectedCurrency = "€";
//        String actualCurrency = driver.findElement(By.cssSelector(".price")).getText();
        String actualCurrency = driver.findElement(By.xpath("//*[contains(text(), '€ Currency')]")).getText();


//        String actualCurrency = driver.findElement(By.cssSelector("#form-currency strong")).getText();
//        Assertions.assertEquals(expectedCurrency, actualCurrency);
    }
}
