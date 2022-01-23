package Proje.Odev2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BucketPage {
    WebDriver driver;

    public BucketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table:nth-child(7) > tbody > tr > td.prodPrice > div.spinnerField > div > span.spinnerUp.spinnerArrow")
    @CacheLookup
    WebElement priceArea;

    @FindBy(css = "#js-buyBtn")
    @CacheLookup
    WebElement purchaseBtn;

    @FindBy(css = "html body div#userKvkkModal.lightBox.guestKvkkLb div.content span.closeBtn")//"#userKvkkModal > div > div.btnHolder > span")
    @CacheLookup
    WebElement disableKvkPopup;

    void disablePopUp() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        disableKvkPopup.click();
    }

    public void handle() {
        disablePopUp();
        for (int i = 1; i <= 2; i++) {
            try {
                priceArea.click();
            } catch (Exception ex){//disablePopUp();
                i--;}
        }
        purchaseBtn.click();
    }
}
