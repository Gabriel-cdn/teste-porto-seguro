package teste1.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OperadorDriver {

    private static WebDriver driver;

    public static void startDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static void acessarUrl(String url) {
        Logger.logarPasso(String.format("Acessando Url: %s", url));
        OperadorDriver.getDriver().get(url);
    }

}
