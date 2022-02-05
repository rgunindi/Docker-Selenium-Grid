package Proje.Odev3.navigationUrl;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Navigate {
    public WebDriver driver;
    public Navigate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openN11HomePage(String url){
        driver.get(url);
        Assert.assertEquals("n11.com - Hayat Sana Gelir", driver.getTitle());
    }
}
