/*Need to work on:
 * - Determining condition of patient based on glucose levels
 * - Printing glucose units in print statement
 * - File reading, then using that data in this code
 * - Pre-diabetic menu-driven part
 * - Printing other useful information like what "1 Fat item" means, etc. before offering menu of meals.
 */

 import java.util.*;

 public class Main {
     private static char condition; // Store the condition of the patient here (p = Pre-Diabetic, d = Diabetic, n = Non-Diabetic)
     private static int mealchoice; // Meal choice
     private static int[] glucose = new int[2]; // Glucose levels of previous 2 days
 
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         /*Trial */ condition = 'd';
         // Need to add units of glucose in this print statement
         System.out.printf("Welcome to the diabetes diet suggestion application!\nPlease input your glucose levels of the past two days: \nFormat: - Previous day\n\t- The day before the preceding day\nUnits: \n");
         glucose[0] = sc.nextInt(); // Previous day
         glucose[1] = sc.nextInt(); // The day before glu[0]'s day
 
         // Determine cond based on glu[0], glu[1]
 
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
                         System.out.printf("You have selected breakfast.\nYou are allowed to eat:\n1 Fruit\n2 Starch items/Bread\n1 Fat item\n1 Milk serving\nFree foods\n");
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
 