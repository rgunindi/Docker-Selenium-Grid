package Proje.Odev1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11Page {
    public WebDriver driver;

    public N11Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[3]/nav/ul/li[5]/span") ////*[@id="header"]/div/div/div[3]/nav/ul/li[5]/span
    @CacheLookup    ///html/body/div[1]/header/div/div/div[3]/nav/ul/li[5]/span
    WebElement xpathMagazalar;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div[3]/nav/ul/li[5]/div/div/a[1]")
    @CacheLookup
    WebElement xpathMagazalariGor;


    @FindBy(xpath = "//*[@id=\"myLocation-close-info\"]")
    @CacheLookup
    WebElement disablePopup;
    void disablePopUp(){disablePopup.click();}

    public void clickOnTumMagazalariGor() {
        try{disablePopUp();}catch (Exception ignored){}
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(xpathMagazalar).perform();
        try{  Thread.sleep(1000);}catch (Exception ignored){}//sleep 1 second.
        action.moveToElement(xpathMagazalariGor).perform();
        action.click().perform();
    }



}
