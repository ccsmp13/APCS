import java.util.Scanner;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("resource")
public class Receipt {
    public static void main(String[] args) {

        Scanner foodCostScanner = new Scanner(System.in);
        System.out.print("Total cost of food items: ");
        double foodCost = foodCostScanner.nextFloat();
        foodCostScanner.nextLine();
       

        Scanner nonFoodScanner = new Scanner(System.in);
        System.out.print("Total cost of non-food items: ");
        double nonFoodCost = nonFoodScanner.nextFloat();
        nonFoodScanner.nextLine();
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        String s = ZonedDateTime.now(ZoneId.of("America/Chicago"))
                .format(DateTimeFormatter.ofPattern("MM/dd/uuuu  HH:mm:ss"));

        System.out.println("RECEIPT");
        System.out.println(s);
        
        System.out.println();
        System.out.println();

        
        String foodCostFormat = String.format("Cost of food items: %10.2f", foodCost);
        String nonFoodFormat = String.format("Cost of Non-food items: %6.2f", nonFoodCost);
        double subtotal = foodCost + nonFoodCost;
        String subtotalFormat = String.format("Item SUBTOTAL: %15.2f", subtotal);
        
        System.out.println(foodCostFormat);
        System.out.println(nonFoodFormat);
        System.out.println(subtotalFormat);
        
        System.out.println();
        System.out.println();
        
        double foodTax = .01 * foodCost;
        double nonFoodTax = .0875 * nonFoodCost;
        String foodTaxTotal = String.format("Tax on food items: %11.2f", foodTax);
        String nonFoodTaxTotal = String.format("Tax on non-food items: %7.2f", nonFoodTax);
        
        System.out.println(foodTaxTotal);
        System.out.println(nonFoodTaxTotal);
        
        System.out.println();
        System.out.println();

        double total = foodTax + nonFoodTax + subtotal;
        String totalString = String.format("TOTAL: %23.2f", total);

        System.out.println(totalString);
        





    }
}