package Proje.Odev3.driverControl;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class driverShutdown {
    public void driverClose(WebDriver driver){driver.quit();}
}
