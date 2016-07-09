package de.schroeder.checkout.simple;

import de.schroeder.checkout.simple.controller.InputController;

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
