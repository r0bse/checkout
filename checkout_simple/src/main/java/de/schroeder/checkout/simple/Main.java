package de.schroeder.checkout.simple;

import de.schroeder.checkout.simple.controller.InputController;
import de.schroeder.checkout.simple.service.PriceCalculationService;
import de.schroeder.checkout.simple.service.ProductFactory;
import de.schroeder.checkout.simple.util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main( String[] args ) {

        InputController inputController = InputController.getInstance();

        //simple main loop
        do {
            inputController.menu();
        }
        while ( true );
    }
}
