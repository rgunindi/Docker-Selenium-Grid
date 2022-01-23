package Proje.Odev1.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Proje.Odev1.pageObjects.MagazalarPage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BufferedWriteFile {
    List<String> lettersXpath;
    PrintWriter outFile;
    WebDriver driver;

    public BufferedWriteFile(WebDriver driver){
        this.driver=driver;
        lettersXpath=new ArrayList<>();
        try{ outFile= new PrintWriter(new BufferedWriter(new FileWriter("AtoZmagazalar.csv"))); }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void printToFile() {
        String xpath= MagazalarPage.xpathMagazaLetter;
        //31 Letter A..Z
        for (int i = 1; i <=31; i++) {//SIMDILIK 2 YAPTIK 31 OLACAK..
            lettersXpath.add(xpath+"/span["+i+"]"); //-->span[i]
        }
        int countLetter=0;
        for (String x:lettersXpath){
            countLetter++;
            try{ Thread.sleep(1000);}catch(Exception ex) {}
            boolean selecties=driver.findElement(By.xpath(x)).isSelected(); if (!selecties)driver.findElement(By.xpath(x)).click();
           try{ Thread.sleep(3000);}catch(Exception ex) {}
            int beginIndex=x.lastIndexOf("[");
            int endIndex=x.lastIndexOf("]");
            String letterText=x.substring(beginIndex+1,endIndex);
            while (countLetter!=Integer.parseInt(letterText))
            {
            }
            WebElement storeList = driver.findElement(By.xpath("//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[2]/ul"));
            List<WebElement> storeNames = storeList.findElements(By.tagName("li"));
            for (WebElement li:storeNames){
                if (outFile!=null){
                    String txtStoreName=li.getText();
                    String storeUrl=li.findElement(By.tagName("a")).getAttribute("href");
                    try{  outFile.println(txtStoreName+" "+storeUrl);}catch (Exception ignored){}
                }
            }
            outFile.flush();
        }
        outFile.close();
    }
}
