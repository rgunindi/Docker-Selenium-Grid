package Proje.Odev1.utilities;

import java.io.*;
import java.util.Objects;

public class BufferedReadFile {
   public static String magazaUrl;
    BufferedReader inputFile;
    public BufferedReadFile(){
        //PageFactory.initElements(MagazalarPage.driver, this);

        // magazalar=new ArrayList<>(); //new BufferedReader(new FileReader("AtoZmagazalar.csv"))); inputFile= new FileReader(("AtoZmagazalar.csv"));
        try{ inputFile=new BufferedReader(new FileReader("AtoZmagazalar.csv"));}
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void readFile(){
        int countS=0;
        try{ boolean end=true;
        while (end){
        String line=inputFile.readLine();
        if (line==null){end=false;break;}
        String str=line.substring(0,1).toUpperCase();
        if (Objects.equals(str,"S")){
            countS++;
            if (countS==2){
                int n=line.indexOf(' ');
                magazaUrl=line.substring(n+1);
                break; }}
        }

        }
        catch (Exception ex){}

    }
}
