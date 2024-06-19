package sauce;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static sauce.utils.Utils.loadElementProperties;

public class Drivers {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    public static void loadElements() {
        loadElementProperties();
    }

    @Before
    public static void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @After
    public static void quitDriver(){
        driver.quit();
    }
}
