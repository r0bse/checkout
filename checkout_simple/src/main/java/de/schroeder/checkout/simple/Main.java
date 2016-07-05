package de.schroeder.checkout.simple;

import de.schroeder.checkout.simple.service.PriceCalculationService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String keepRunning;
        String productNames = "";

        Scanner scanner = new Scanner(System.in);
        PriceCalculationService calculationService = PriceCalculationService.getInstance();

        //simple main loop
        do {
            System.out.print("Please enter the desired checkout items [A-D] in any order:  ");
            productNames = scanner.next();
            productNames = productNames.toUpperCase();

            Integer price = calculationService.calculatePrice(productNames);
            System.out.println(String.format("The total price of given Products is: %s", price.toString() ));

            System.out.println();
            System.out.println("If you want another Checkout press [y]  If not press something else. \nThen press [Enter]");
            keepRunning = scanner.next();

        }
        while (keepRunning.equals("y"));
    }
}
