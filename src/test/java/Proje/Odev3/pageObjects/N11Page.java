package Proje.Odev3.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11Page {
    public WebDriver driver;
    public N11Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "searchData")
    @CacheLookup
    WebElement searchBox;

    @FindBy(className = "searchBtn")
    @CacheLookup
    WebElement searchBtn;

    @FindBy(xpath = "//*[text()[contains(.,'Iphone')]]")
    @CacheLookup
    WebElement resultIphone;

    @FindBy(xpath = "//*[@id=\"myLocation-close-info\"]")
    @CacheLookup
    WebElement disablePopup;
    void disablePopUp(){disablePopup.click();}

    public void searchWord(String word) {
        disablePopUp();
    searchBox.sendKeys(word);
    searchBtn.click();
        waits(2);
        Assert.assertNotNull("ayfone is showed Iphone", resultIphone);
    }

    void waits(int time) {
        try {
            Thread.sleep((time * 1000L));
        } catch (Exception ignored) {
        }
    }
}
