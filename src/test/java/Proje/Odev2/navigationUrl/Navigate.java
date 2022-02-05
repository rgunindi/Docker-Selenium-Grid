package Proje.Odev2.navigationUrl;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Navigate {
    WebDriver driver;

    public Navigate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void openN11HomePage(String url){
        driver.get(url);
        Assert.assertEquals("n11.com - Hayat Sana Gelir", driver.getTitle());
    }

    public void goBucket(){
        driver.get("https://www.n11.com/sepetim");
        Assert.assertEquals("https://www.n11.com/sepetim", driver.getCurrentUrl());
    }
}
