package locators_03;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class css {
    @Test
    public void cssTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=product/search");
        driver.findElement(By.cssSelector("a")).click();
    }

    @Test
    void task(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
//        Isspausdint elemento (id=logo) teksta
        System.out.println(driver.findElement(By.id("logo")).getText());

        driver.findElement(By.cssSelector("#search button")).click();
//        driver.findElement(By.cssSelector(".fa-search")).click();
        driver.quit();

    }

//    ONLY By.cssSelector
    @Test
    void onlyCss() {
//        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        System.out.println(driver.findElement(By.id("logo")).getText());
//        driver.findElement(By.name("search")).sendKeys("abc");
        driver.findElement(By.cssSelector("[name=search]")).sendKeys("abc");
        driver.findElement(By.className("fa-search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("iphone");
        driver.findElement(By.id("search")).findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.id("cart")).getText());
        System.out.println(driver.findElements(By.className("product-thumb")).size());
        String iphonePrice = driver.findElement(By.className("price")).getText();
        System.out.println(iphonePrice);
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("f-name");
        driver.findElement(By.id("input-lastname")).sendKeys("l-name");
        driver.findElement(By.id("input-email")).sendKeys("a@a.com");
        driver.findElement(By.id("input-telephone")).sendKeys("123");
        driver.findElement(By.id("input-password")).sendKeys("qwqwqw");
        driver.findElement(By.id("input-confirm")).sendKeys("qwqwqw");
        driver.findElement(By.name("agree")).click();
        driver.findElements(By.className("pull-right")).getLast()
                .findElements(By.tagName("input")).get(1).click();
        driver.quit();
    }

    //   ONLY By.xpath
    @Test
    void onlyXpath() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']")).getText());
//        driver.findElement(By.name("search")).sendKeys("abc");
        driver.findElement(By.cssSelector("[name=search]")).sendKeys("abc");
        driver.findElement(By.className("fa-search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("iphone");
        driver.findElement(By.id("search")).findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.id("cart")).getText());
        System.out.println(driver.findElements(By.className("product-thumb")).size());
        String iphonePrice = driver.findElement(By.className("price")).getText();
        System.out.println(iphonePrice);
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("f-name");
        driver.findElement(By.id("input-lastname")).sendKeys("l-name");
        driver.findElement(By.id("input-email")).sendKeys("a@a.com");
        driver.findElement(By.id("input-telephone")).sendKeys("123");
        driver.findElement(By.id("input-password")).sendKeys("qwqwqw");
        driver.findElement(By.id("input-confirm")).sendKeys("qwqwqw");
        driver.findElement(By.name("agree")).click();
        driver.findElements(By.className("pull-right")).getLast()
                .findElements(By.tagName("input")).get(1).click();
        driver.quit();
    }
}
