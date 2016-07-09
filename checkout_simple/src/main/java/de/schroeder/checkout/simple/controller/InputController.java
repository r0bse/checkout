package de.schroeder.checkout.simple.controller;

import de.schroeder.checkout.simple.service.NumberParseService;
import de.schroeder.checkout.simple.service.PriceCalculationService;
import de.schroeder.checkout.simple.service.ProductFactory;
import de.schroeder.checkout.simple.util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * class is responsible for getting input from commandline
 *
 * @author schroeder
 * @date 07. Jul 2016
 */
public class InputController {

    private static InputController instance;
    private static Scanner scanner = ScannerUtil.getScanner();
    private static NumberParseService numberParseService = NumberParseService.getInstance();

    /**
     * private constructor for singleton instantiation
     */
    private InputController() {
    }

    /**
     * get the instance of this class as singleton
     *
     * @return
     */
    public static final InputController getInstance() {

        if ( instance == null ) {
            instance = new InputController();
        }
        return instance;
    }

    /**
     * the main menu
     */
    public void menu() {

        System.out.println( "\nIf you want to insert the productlist, press \t\"1\".");
        System.out.println( "If you want to add an new rule press \t\"2\".");
        System.out.println( "If you want to exit the programm, press \t\"3\"." );
        System.out.println("Then press [Enter]\n");

        String input = scanner.next();

        switch(input) {
            case "1":
                askForProductInput();
                calculateTotal();
                break;
            case "2":
                addRule();
                break;
            case "3":
                exitProgramm();
                break;
            default:
                System.out.println( "\nCommand not recognized!" );
                break;
        }
        //recursive call to keep popping up the main menu
        menu();
    }

    /**
     * add a a new product to available productlist
     * will NOT be persisted, that means it will be deleted after exiting the program
     */
    private void addRule() {

        ProductFactory productFactory = ProductFactory.getInstance();

        System.out.println( "\nPlease insert the productname (only the first character will be used): " );
        String productName = scanner.next().toUpperCase();

        System.out.println( "\nPlease insert the default price in Cents: " );
        String defaultPriceString = scanner.next();
        Long defaulPrice = numberParseService.parseToLong( defaultPriceString );

        System.out.println( "\nPlease insert the amount of purchased products which triggers the discount: " );
        String discountAmountString = scanner.next();
        Integer discountAmount = numberParseService.parseToInteger( discountAmountString );

        System.out.println( "\nPlease insert the price of a discount: " );
        String discountPriceString = scanner.next();
        Double discountPrice = numberParseService.parseToDouble( discountPriceString );

        productFactory.addOrChangeProduct(productName.charAt(0), defaulPrice, discountAmount, discountPrice);

    }

    /**
     * look into current available products and create a String which asks for input
     */
    private void askForProductInput() {

        ProductFactory productFactory = ProductFactory.getInstance();

        Set<Character> productSet = productFactory.getProductMap().keySet();

        List<Character> sortedProducts = new ArrayList<>();
        productSet.stream()
                .sorted() //sort for better readability
                .forEach( c -> sortedProducts.add( c ) );

        System.out.print( String.format( "\nPlease enter the desired checkout items %s in any order:  ", sortedProducts ) );
    }

    /**
     * read given values and calculate the total price
     */
    private void calculateTotal() {

        PriceCalculationService calculationService = PriceCalculationService.getInstance();

        String productNames;
        productNames = scanner.next();
        productNames = productNames.toUpperCase();

        try {
            Integer price = calculationService.calculatePrice( productNames );
            System.out.println( String.format( "\nThe total price of given Products is: %s", price.toString() ) );
        }
        catch(IllegalArgumentException e){
            System.out.println( "I could not find your desired product. Are you sure it is in the list?\nI will redirect you to the main menu." );
            menu();
        }
    }

    /**
     * exits the programm
     */
    private void exitProgramm() {
        System.out.println( "\nThank you and good bye :-)" );
        System.exit( 0 );
    }
}
