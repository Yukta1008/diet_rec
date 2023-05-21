package Operations;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class Printer {
    public static void tableprint(String s, String d){
        System.out.printf("%20s%20s",s,d);
        System.out.println();
    }
    public static void tableprint(String s){
        System.out.printf("%20s",s);
    }
    public static void tableprint(int n, int m, XSSFSheet sheet){
        for(int r=n; r<m; r++) {
            XSSFRow row = sheet.getRow(r);
            String s = row.getCell(0).toString();
            System.out.print(r - 113 + ".");
            tableprint(s);
            System.out.println();
        }
    }
//    public static void main(String[] args) throws IOException {
//        tableprint("lol", "lmao");
//    }
}
