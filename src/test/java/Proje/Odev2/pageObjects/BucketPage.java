package Proje.Odev2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class BucketPage {
    WebDriver driver;

    public BucketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "td.prodPrice > div.priceTag > div > span")
    @CacheLookup
    List<WebElement> priceAreas;

    @FindBy(css = "td.prodPrice > div.spinnerField > div > span.spinnerUp.spinnerArrow")
    @CacheLookup
    List<WebElement> addProduct;

    @FindBy(css = "#js-buyBtn")
    @CacheLookup
    WebElement purchaseBtn;

    @FindBy(css = "html body div#userKvkkModal.lightBox.guestKvkkLb div.content span.closeBtn")//"#userKvkkModal > div > div.btnHolder > span")
    @CacheLookup
    WebElement disableKvkPopup;

    void disablePopUp() {
        try {
            waits(3);
            disableKvkPopup.click();
        } catch (Exception e) {
        }

    }

    void calculatingAmountProduct(){
        waits(2);
        Map<Integer, WebElement> amountMap = new HashMap<Integer, WebElement>();
        List<WebElement> elMap = new ArrayList<>(addProduct);
        int count=0;
        for (WebElement el:priceAreas) {
            Integer amount=Integer.parseInt(el.getText().replaceAll("\\D+",""));
            amountMap.put(amount, elMap.get(count));
            count++;
        }
        List sortedAmounts=new ArrayList(amountMap.keySet());
        Collections.sort(sortedAmounts);
        WebElement el= amountMap.get(sortedAmounts.get(0));
        el.click();
        waits(1);
    }
    public void handle() {
        disablePopUp();
        calculatingAmountProduct();
        purchaseBtn.click();
    }
    void waits(int time) {
        try {
            Thread.sleep((time * 1000L));
        } catch (Exception ignored) {
        }
    }
}
