package Proje.Odev1.pageObjects;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagazalarPage {
    public static WebDriver driver;
    public MagazalarPage(WebDriver driver) {
        MagazalarPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"contentSellerList\"]/div/div[2]/div/div[1]/ul/li[4]/div/h3")
    @CacheLookup
    WebElement xpathTumMagazalar;

    @FindBy(css = "#contentSellerList > div > div.tabList > div > div.tabPanelHolder > div.tabPanel.allSellers > h2")
    @CacheLookup
    WebElement cssAllSellerTxt;

    public static String xpathMagazaLetter="//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[1]";

    public void clickOnTumMagazalar() {
        waits(1);
        xpathTumMagazalar.click();
        waits(1);
        Assert.assertEquals("Tüm Mağazalar", cssAllSellerTxt.getText());
    }

    void waits(int time) {
        try {
            Thread.sleep((time * 1000L));
        } catch (Exception ignored) {
        }
    }
}
