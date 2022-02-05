package Proje.Odev3.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    public WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "section.filter:nth-child(6) > div:nth-child(3) > div:nth-child(2)")
    @CacheLookup
    WebElement secondBrand;

    @FindBy(id = "sortingType")
    @CacheLookup
    WebElement sortingType;

    @FindBy(id = "freeShippingOption")
    @CacheLookup
    WebElement freeShipping;

    public void selectSecondBrand() { waits(2);
        Assert.assertNotNull(secondBrand);
        secondBrand.findElements(By.tagName("label")).get(0).click();//->SecondBrand is clicked
        waits(2);
    }

    public void sortingByComments() {
        Assert.assertNotNull(sortingType);
        new Select(sortingType).selectByValue("REVIEWS");
        waits(2);
    }

    public void freeShippingList() {
        freeShipping.click();
        Assert.assertTrue(driver.findElement(By.id("freeShippingOption")).isSelected()); //free shipping IsSelected ?
    }

    void waits(int time){
        try{Thread.sleep((time* 1000L));}catch (Exception ignored){}
    }
}
