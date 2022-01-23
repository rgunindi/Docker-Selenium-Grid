package Proje.Odev1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MagazalarPage {
    public static WebDriver driver;
//    List<String> lettersXpath;
//    PrintWriter outFile;
    public MagazalarPage(WebDriver driver) {
        MagazalarPage.driver = driver;
        PageFactory.initElements(driver, this);
//        lettersXpath=new ArrayList<>();
//        try{ outFile= new PrintWriter(new BufferedWriter(new FileWriter("AtoZmagazalar.csv"))); }catch (Exception ex){
//            System.out.println(ex);
//        }
    }


    @FindBy(xpath = "//*[@id=\"contentSellerList\"]/div/div[2]/div/div[1]/ul/li[4]/div/h3")
    @CacheLookup
    WebElement xpathTumMagazalar;

    @FindBy(xpath = "//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[2]/ul")
    @CacheLookup
    public static WebElement xpathstoreNames;

    public static String xpathMagazaLetter="//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[1]";

    public void clickOnTumMagazalar() {
        try{  Thread.sleep(1000);}catch (Exception ignored){}//sleep 1 second.
        xpathTumMagazalar.click();
    }
    //*[@id="contentSellerList"]/div/div[2]/div/div[2]/div[4]/div[1]/span[1]--> /span[n]
//    public void printToFile() {
//        String xpath=xpathMagazaLetter;//.toString().substring(0,xpathMagazaLetter.toString().length()-1)
//
//        //31 Letter A..Z
//        for (int i = 1; i <=31; i++) {
//            lettersXpath.add(xpath+"/span["+i+"]"); //-->span[i]
//        }
//        int countLetter=0;
//        for (String x:lettersXpath){
//            countLetter++;
//        boolean selecties=driver.findElement(By.xpath(x)).isSelected(); if (!selecties)driver.findElement(By.xpath(x)).click();
//        String letterText=x.substring(x.length()-2,x.length()-1);
//        while (countLetter!=Integer.parseInt(letterText))
//        {
//        }
//            WebElement storeList = driver.findElement(By.xpath("//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[2]/ul"));
//            List<WebElement> storeNames = storeList.findElements(By.tagName("li"));
//
//            for (WebElement li:storeNames){
//                if (outFile!=null){
//                    String txtStoreName=li.getText();
//                    String storeUrl=li.findElement(By.tagName("a")).getAttribute("href");
//                    try{  outFile.println(txtStoreName+" "+storeUrl);}catch (Exception ignored){}
//                }
//            }
//            outFile.flush();
//        }
////        for (String x:lettersXpath){
////            if (outFile!=null){
////                try{  outFile.println(x);}catch (Exception ignored){}
////            }
////        }
//        outFile.close();
//    }
}
