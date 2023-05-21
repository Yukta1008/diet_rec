package Operations;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Project extends Printer{
    static char condition; // Store the condition of the patient here (p = Pre-Diabetic, d = Diabetic, n = Non-Diabetic)
    static int mealchoice; // Meal choice
    static int[] glucose = new int[2]; // Glucose levels of previous 2 days
    public static void main (String[] args) throws IOException {

        String filePath = ".\\Data\\Project.xlsx";
        FileInputStream is = new FileInputStream(filePath);

        XSSFWorkbook wb = new XSSFWorkbook(is);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

//        for(int r=0; r<=rows; r++){
//            XSSFRow row = sheet.getRow(r);
//            for(int c=0; c<cols; c++){
//                XSSFCell cell = row.getCell(c);
//                switch(cell.getCellType()) {
//                    case STRING:
//                        System.out.print(cell.getStringCellValue() + " ");
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + " ");
//                        break;
//                    case BOOLEAN:
//                        System.out.println(cell.getBooleanCellValue());
//                        break;
//                }
//                System.out.println();
//            }
//        }

            Scanner sc = new Scanner(System.in);
            // Need to add units of glucose in this print statement
            System.out.printf("Welcome to the diabetes diet suggestion application!\nPlease input your glucose levels of the past two days: \n(Units: mg/dL)\n");
            System.out.printf("Glucose on the previous day: ");
            glucose[0] = sc.nextInt(); // Previous day
            System.out.printf("\nGlucose levels of the day before the preceding day: ");
            glucose[1] = sc.nextInt(); // The day before glu[0]'s day
            System.out.printf("\n");
            int avgglu = ((glucose[0] + glucose[1])/2);

            if (avgglu >= 100 && avgglu <= 125){
                condition = 'p';
            }
            else if (avgglu >= 126){
                condition = 'd';
            }
            else if (avgglu <= 99){
                condition = 'n';
            }

            if (condition == 'n'){
                System.out.printf("The user is non-diabetic. Diet suggestions not valid.\n");
            }
            else{
                // Pre-Diabetic
                if (condition == 'p'){
                    System.out.printf("The user is pre-diabetic.\n");
                    while(true){
                        System.out.printf("Please choose your meal:\n1. Breakfast\n2. Lunch\n3. Afternoon Snack\n4. Dinner\n5. Evening Snack\n6. Exit\n");
                        mealchoice = sc.nextInt();
                        if (mealchoice == 2){
                            break;
                        }
                    }
                }

                // Diabetic
                else if (condition == 'd'){
                    System.out.printf("The user is diabetic.\n");
                    while(true){
                        System.out.printf("Please choose your meal:\n1. Breakfast\n2. Lunch\n3. Afternoon Snack\n4. Dinner\n5. Evening Snack\n6. Exit\n");
                        mealchoice = sc.nextInt();
                        if (mealchoice == 1){
                            //System.out.printf("You have selected breakfast.\nYou are allowed to eat:\n1 Fruit\n2 Starch items/Bread\n1 Fat item\n1 Milk serving\nFree foods\n");
                            for(int r=1; r<6; r++) {
                                XSSFRow row = sheet.getRow(r);
                                for(int c=0; c<2; c++){
                                    //XSSFCell cell = row.getCell(c);
                                    String s = row.getCell(c).toString();
                                    tableprint(s);
                                }
                                System.out.println();
                            }
                            System.out.println("Choose a fruit");
//                            for(int r=114; r<129; r++) {
//                                XSSFRow row = sheet.getRow(r);
//                                String s = row.getCell(0).toString();
//                                System.out.print(r-113 + ".");
//                                tableprint(s);
//                                System.out.println();
//                            }
                            tableprint(114,129,sheet);
                            int n = sc.nextInt();
                            String fruit = sheet.getRow(1131+n).getCell(0).toString();
                            System.out.println(fruit);
                            System.out.println("Choose a bread");

                        }
                        if(mealchoice == 2){
                            System.out.printf("You have selected lunch.\nYou are allowed to eat:\n1 Meat item\n2 Starch items/Bread\n1 Vegetable\n1 Fruit\n1 Fat item\nFree foods\n");
                        }
                        if(mealchoice == 3){
                            System.out.printf("You have selected afternoon snack.\nYou are allowed to eat:\n1 Fruit\n");
                        }
                        if(mealchoice == 4){
                            System.out.printf("You have selected dinner.\nYou are allowed to eat:\n2 Meat items\n2 Starch items/Bread\n1 Vegetable\n1 Fruit\n2 Fat items\nFree foods\n");
                        }
                        if(mealchoice == 5){
                            System.out.printf("You have selected evening snack.\nYou are allowed to eat:\n1 Starch item/Bread\n1 Milk serving\n1 Fruit\n");
                        }
                        if (mealchoice == 6){
                            System.out.printf("Exiting...\n");
                            break;
                        }
                    }
                }
            }
            sc.close();


    }
}
