package Proje.Odev2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11Page {
    WebDriver driver;
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


    @FindBy(xpath = "//*[@id=\"myLocation-close-info\"]")
    @CacheLookup
    WebElement disablePopup;
    void disablePopUp(){disablePopup.click();}

    public void searchWord(String word) {
        disablePopUp();
    searchBox.sendKeys(word);
    searchBtn.click();
    }
}
