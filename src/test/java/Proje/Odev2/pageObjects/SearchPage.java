package Proje.Odev2.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchPage {
    WebDriver driver;
    List<WebElement> productList;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"view\"]/ul")
    @CacheLookup
    WebElement searchList;

    @FindBy(xpath = "//*[@id=\"view\"]/ul")
    @CacheLookup
    WebElement searchListp3;

    @FindBy(css = ".addBasketUnify")
    @CacheLookup
    WebElement bucketBtn;

    @FindBy(xpath = "//*[@id=\"contentListing\"]/div/div/div[2]/div[3]/a[3]")
    @CacheLookup
    WebElement thirdPage;

    public void handle() {
        ArrayList productLinks = new ArrayList();
        int count = 0;
        productList = new ArrayList<>();
        waits(2);
        for (WebElement el : searchList.findElements(By.tagName("li"))) {
            if (!Objects.equals(el.getText(), "")) {
                productList.add(el);
                count++;
                if (count == 1 | count == 28) {
                    String Product = el.findElements(By.tagName("a")).get(0).getAttribute("href");
                    productLinks.add(Product);
                }
            }
        }
        thirdPage.click();
        PageFactory.initElements(driver, this);
        count = 0;
        for (WebElement el : searchListp3.findElements(By.tagName("li"))) {
            if (!Objects.equals(el.getText(), "")) {
                productList.add(el);
                count++;
                if (count == 5) {
                    String Product = el.findElements(By.tagName("a")).get(0).getAttribute("href");
                    productLinks.add(Product);
                    break;
                }
            }
        }
        operations(productLinks);
    }

    void operations(ArrayList list) {
        for (Object product : list) {
            driver.get(product.toString());
            waits(2);
            init();
            bucketBtn.click();
            waits(1);
        }
    }

    void init() {
        PageFactory.initElements(driver, this);
    }

    void waits(int time) {
        try {
            Thread.sleep((time * 1000L));
        } catch (Exception ignored) {
        }
    }
}
