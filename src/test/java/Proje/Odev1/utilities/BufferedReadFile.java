package Proje.Odev1.utilities;

import java.io.*;
import java.util.Objects;

public class BufferedReadFile {
    public static String magazaUrl;
    BufferedReader inputFile;

    public BufferedReadFile() {
        try {
            inputFile = new BufferedReader(new FileReader("AtoZmagazalar.csv"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void readFile() {
        int countS = 0;
        try {
            while (true) {
                String line = inputFile.readLine();
                if (line == null) {
                    break;
                }
                String str = line.substring(0, 1).toUpperCase();
                if (Objects.equals(str, "S")) { //s
                    countS++;
                    if (countS == 2) {
                        int n = line.indexOf(' ');
                        magazaUrl = line.substring(n + 1);
                        break;
                    }
                }
            }

        } catch (Exception ex) {
        }

    }
}
