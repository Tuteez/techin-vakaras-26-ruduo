package basics_nuo_Select_02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondDayBasics {
    @Test
    void task() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
//        Isspausdint elemento (id=logo) teksta
        System.out.println(driver.findElement(By.id("logo")).getText());
//        2.Ivesti i paieskos laukeli "abc"
        driver.findElement(By.name("search")).sendKeys("abc");
//        3.paspausti ieskoti (klase = fa-search)

        driver.findElement(By.className("fa-search")).click();
//        4.istrinti paieskos laukelio texta
        driver.findElement(By.name("search")).clear();
//        5.Ivesti i paieskos laukeli "iphone"
        driver.findElement(By.name("search")).sendKeys("iphone");
//        6.paspausti ieskoti:randam elementa (id = search), poto jam randam button ir ji spaudziam
        driver.findElement(By.id("search")).findElement(By.tagName("button")).click();
//        7.Isspausdint krepselio info (id=cart)
        System.out.println(driver.findElement(By.id("cart")).getText());
//        8. isspausdint kiek prekiu rado (class=product-thumb)
        System.out.println(driver.findElements(By.className("product-thumb")).size());
//        9. isspausdint rastos prekes kaina
        String iphonePrice = driver.findElement(By.className("price")).getText();
        System.out.println(iphonePrice);
//        10. atidaryti https://opencart.abstracta.us/index.php?route=account/register
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
//        11. uzpildyti visus privalomus laukus
        driver.findElement(By.id("input-firstname")).sendKeys("f-name");
        driver.findElement(By.id("input-lastname")).sendKeys("l-name");
        driver.findElement(By.id("input-email")).sendKeys("a@a.com");
        driver.findElement(By.id("input-telephone")).sendKeys("123");
        driver.findElement(By.id("input-password")).sendKeys("qwqwqw");
        driver.findElement(By.id("input-confirm")).sendKeys("qwqwqw");
        driver.findElement(By.name("agree")).click();
//        12. paspausti continue
        driver.findElements(By.className("pull-right")).getLast()
                .findElements(By.tagName("input")).get(1).click();
        driver.quit();
    }

    @Test
    void select() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=product/search");

//        sukuriam
        Select category = new Select(driver.findElement(By.name("category_id")));
//        naudojam
        category.selectByVisibleText("PC");

        driver.quit();
    }

    @Test
    void selectHardcoded() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=product/search");

//atidaryti dropdown / select
        driver.findElement(By.name("category_id")).click();

//        issirinkti itema
        driver.findElements(By.tagName("option")).get(1).click();

        driver.quit();
    }

    @Test
    void aa() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
        String a = "asdasd";
        String b = "asdasd";

        a = "new";


        driver.quit();
    }

}
