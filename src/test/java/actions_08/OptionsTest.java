package actions_08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class OptionsTest {
    public OptionsTest() {
    }

    @Test
    public void optionsTest() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        options.addArguments("--incognito");
//        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/buttons");
        driver.quit();
    }

    @Test
    public void mobile() {
        ChromeOptions options = new ChromeOptions();

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 14 Pro");

        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/buttons");
        driver.quit();
    }

    @Test
    public void locationMock() {
        ChromeDriver driver = new ChromeDriver();

        driver.executeCdpCommand(
                "Emulation.setGeolocationOverride",
                Map.of(
                        "latitude", 54.6872,
                        "longitude", 25.2797,
                        "accuracy", 100
                ));
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.quit();
    }

    @Test
    public void mockSlowSpeed() {
        ChromeDriver driver = new ChromeDriver();
        driver.executeCdpCommand("Network.enable", Map.of());

        driver.executeCdpCommand(
                "Network.emulateNetworkConditions",
                Map.of(
                        "offline", false,
                        "latency", 100,
                        "downloadThroughput", 75000,
                        "uploadThroughput", 25000,
                        "connectionType", "cellular3g"
                )
        );

        driver.get("https://www.amazon.com");
        driver.quit();
    }


}
