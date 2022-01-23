package Proje.Odev1.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagazaCommentPage {
    WebDriver driver;
    public MagazaCommentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"contentListing\"]/div/div/div[1]/section[4]/div/div[5]/span[2]/i")
    @CacheLookup
    WebElement xpathMagazaComment;

    public void checkedComment(){
        String commentCount=xpathMagazaComment.getText();
        commentCount=commentCount.substring(1,commentCount.length()-1);//() is deleted
        Assert.assertTrue("Selected store comments count: "+commentCount,true);

        System.out.println("Selected store comments count: "+commentCount);
    }
}
