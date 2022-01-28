package Proje.Odev1.driverControl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class driverControls {
    static ChromeOptions optionsch;
    static FirefoxOptions optionsfi;
    static EdgeOptions optionsed;
    static OperaOptions optionsop;
    static ChromeOptions op = new ChromeOptions();

    public static WebDriver driverControl(WebDriver driver, String driverName, String seleniumGrid) {
        String dockerSeleniumGrid = seleniumGrid.toUpperCase();
        if (Objects.equals(driverName, "Chrome")) {
            chromeOptions();
            WebDriverManager.chromedriver().setup();
            try {
                if (Objects.equals(dockerSeleniumGrid, "FALSE")) {
                    driver = new ChromeDriver(optionsch);
                } else {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsch);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Objects.equals(driverName, "Firefox")) {
            firefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            try {
                if (Objects.equals(dockerSeleniumGrid, "FALSE")) {
                    driver = new FirefoxDriver(optionsfi);
                } else {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsfi);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (Objects.equals(driverName, "Opera")) {
            operaOptions();
            WebDriverManager.operadriver().setup();
            try {
                if (Objects.equals(dockerSeleniumGrid, "FALSE")) {
                    driver = new OperaDriver(optionsop);
                } else {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsop);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (Objects.equals(driverName, "Edge")) {
            edgeOptions();
            WebDriverManager.edgedriver().setup();
            try {
                if (Objects.equals(dockerSeleniumGrid, "FALSE")) {
                    driver = new EdgeDriver(optionsed);
                } else {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsed);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else System.out.println("Driver range out of test.");

        return driver;
    }

    static void chromeOptions() {
        optionsch = new ChromeOptions();
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.verboseLogging", "false");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        optionsch.addArguments("--headless");
        optionsch.addArguments("--no-sandbox");
        optionsch.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        optionsch.addArguments("disable-infobars"); // disabling infobars
        optionsch.addArguments("--disable-extensions"); // disabling extensions
        optionsch.addArguments("--disable-gpu"); // applicable to windows os only
      //  optionsch.addArguments("window-size=1024,1024"); // Bypass OS security model
        optionsch.addArguments("dom.ipc.processCount", "1");
        optionsch.addArguments("security.sandbox.content.level", "5");
        optionsch.addArguments("--disable-notifications");
    }

    static void firefoxOptions() {
        optionsfi = new FirefoxOptions();
        System.setProperty("webdriver.gecko.args", "--disable-logging");
        System.setProperty("webdriver.gecko.silentOutput", "true");
       // optionsfi.addArguments("--headless");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
    }

    static void edgeOptions() {
        optionsed = new EdgeOptions();
        System.setProperty("webdriver.edge.args", "--disable-logging");
        System.setProperty("webdriver.edge.silentOutput", "true");
        optionsed.addArguments("--headless");
        optionsed.addArguments("--no-sandbox");
        optionsed.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        optionsed.addArguments("disable-infobars"); // disabling infobars
        optionsed.addArguments("--disable-extensions"); // disabling extensions
        optionsed.addArguments("--disable-gpu"); // applicable to windows os only
        optionsed.addArguments("--width=1024"); // Bypass OS security model 1920*1080
        optionsed.addArguments("--height=768");
        optionsed.addArguments("dom.ipc.processCount", "1");
        optionsed.addArguments("security.sandbox.content.level", "5");
        optionsed.addArguments("--disable-notifications");
    }

    static void operaOptions() {
        optionsop = new OperaOptions();
        System.setProperty("webdriver.opera.args", "--disable-logging");
        System.setProperty("webdriver.opera.silentOutput", "true");
        optionsop.addArguments("--headless");
        optionsop.addArguments("--no-sandbox");
        optionsop.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        optionsop.addArguments("disable-infobars"); // disabling infobars
        optionsop.addArguments("--disable-extensions"); // disabling extensions
        optionsop.addArguments("--disable-gpu"); // applicable to windows os only
        optionsop.addArguments("--width=1024"); // Bypass OS security model 1920*1080
        optionsop.addArguments("--height=768");
        optionsop.addArguments("dom.ipc.processCount", "1");
        optionsop.addArguments("security.sandbox.content.level", "5");
        optionsop.addArguments("--disable-notifications");
    }
}
