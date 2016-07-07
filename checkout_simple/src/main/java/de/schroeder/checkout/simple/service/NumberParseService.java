package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.controller.InputController;

/**
 * @author schroeder
 * @date 07. Jul 2016
 */
public class NumberParseService {

    private static NumberParseService instance;

    private InputController inputController = InputController.getInstance();

    private NumberParseService() {
    }

    /**
     * get the instance of this class as singleton
     *
     * @return
     */
    public static final NumberParseService getInstance() {

        if ( instance == null ) {
            instance = new NumberParseService();
        }
        return instance;
    }

    public Double parseToDouble( String value ) {
        try {
            return Double.valueOf( value );
        } catch ( NumberFormatException e ) {
            redirectToMainMenu();
        }
        return 0.0;
    }

    public Integer parseToInteger( String value ) {
        try {
            return Integer.valueOf( value );
        } catch ( NumberFormatException e ) {
            redirectToMainMenu();
        }
        return 0;
    }

    public Long parseToLong( String value ) {
        try {
            return Long.valueOf( value );
        } catch ( NumberFormatException e ) {
            redirectToMainMenu();
        }
        return 0L;
    }

    /**
     * when exception is catched, redirect to mainMenu
     */
    private void redirectToMainMenu() {
        System.out.println( "An exception occured! I expected a number, but got something else.\n I will redirect you to the main menu." );
        inputController.menu();
    }
}
