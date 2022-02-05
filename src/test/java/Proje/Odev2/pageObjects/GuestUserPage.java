package Proje.Odev2.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GuestUserPage {
    WebDriver driver;
    public GuestUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#loginForm > a")
    @CacheLookup
    WebElement guestUserLink;

    @FindBy(id = "guestEmail")
    @CacheLookup
    WebElement guestEmail;

    @FindBy(id = "js-guestEmailCheck")
    @CacheLookup
    WebElement continueBtn;

    @FindBy(id = "fullName")
    @CacheLookup
    WebElement fullName;

    @FindBy(id = "cityId")
    @CacheLookup
    WebElement cityId;

    @FindBy(id = "districtId")
    @CacheLookup
    WebElement districtId;

    @FindBy(id = "neighbourhoodId")
    @CacheLookup
    WebElement neighbourhoodId;

    @FindBy(id = "postalCode")
    @CacheLookup
    WebElement postalCode;

    @FindBy(id = "addressDetail")
    @CacheLookup
    WebElement addressDetail;

    @FindBy(id = "gsm")
    @CacheLookup
    WebElement gsm;

    @FindBy(id = "shippingAddresstcNO")
    @CacheLookup
    WebElement shippingAddresstcNO;

    @FindBy(id = "addressName")
    @CacheLookup
    WebElement addressName;

    @FindBy(id = "js-goToPaymentBtn")
    @CacheLookup
    WebElement goToPaymentBtn;

    public void fillForm() { try{Thread.sleep(2000);}catch (Exception e){}
        guestUserLink.click();
        Assert.assertEquals("https://www.n11.com/misafir-sepet", driver.getCurrentUrl());
        waits(1);
        guestEmail.sendKeys("n11guestUser@sharklasers.com");
        continueBtn.click();
        waits(1);

        fullName.sendKeys("Razaman Gunindi");

        Select city=new Select(cityId);
        city.selectByValue("2535");
        waits(1);
        new Select(districtId).selectByValue("23076");
        waits(1);
        new Select(neighbourhoodId).selectByValue("44323");

        addressDetail.sendKeys("Karsiyaka Izmir");

        gsm.click();gsm.sendKeys("5531231239");
        shippingAddresstcNO.sendKeys("10000000832");
        addressName.sendKeys("Evim");
        goToPaymentBtn.click();
        waits(2);
    }
    void waits(int time){
        try{Thread.sleep((time* 1000L));}catch (Exception ignored){}
    }

}
