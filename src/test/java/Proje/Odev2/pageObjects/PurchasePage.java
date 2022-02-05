package Proje.Odev2.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {
    WebDriver driver;
    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#newCheckout > div > div > div.right > div > section.box.box--small.orderSummaryBox > div.contractField.guest > div > label")
    @CacheLookup
    WebElement acceptAggrement;


    @FindBy(xpath = "//*[@id=\"creditCardTabPanel\"]/div[3]/div[1]/input[2]")
    @CacheLookup
    WebElement cardBox1;

    @FindBy(xpath = "//*[@id=\"creditCardTabPanel\"]/div[3]/div[1]/input[3]")
    @CacheLookup
    WebElement cardBox2;

    @FindBy(xpath = "//*[@id=\"creditCardTabPanel\"]/div[3]/div[1]/input[4]")
    @CacheLookup
    WebElement cardBox3;

    @FindBy(xpath = "//*[@id=\"creditCardTabPanel\"]/div[3]/div[1]/input[5]")
    @CacheLookup
    WebElement cardBox4;

    @FindBy(id = "cardOwnerName")
    @CacheLookup
    WebElement cardOwnerName;

    @FindBy(id = "expireMonth")
    @CacheLookup
    WebElement expireMonth;

    @FindBy(id = "expireYear")
    @CacheLookup
    WebElement expireYear;

    @FindBy(id = "securityCode")
    @CacheLookup
    WebElement securityCode;

    @FindBy(id = "js-paymentBtn")
    @CacheLookup
    WebElement paymentBtn;

    @FindBy(css = ".errorMessage")
    @CacheLookup
    WebElement errorMessage;

public void purchase(){
    cardBox1.sendKeys("1234");
    cardBox2.sendKeys("1234");
    cardBox3.sendKeys("1234");
    cardBox4.sendKeys("1234");
    cardOwnerName.sendKeys("Ramazan G");
    new Select(expireMonth).selectByValue("1");
    new Select(expireYear).selectByValue("2024");
    securityCode.sendKeys("321");
    acceptAggrement.click();
    paymentBtn.click();
    Assert.assertEquals("Geçersiz kredi kartı numarası.", errorMessage.getText());
}
}
