package de.schroeder.checkout.simple.util;

import java.util.Scanner;

/**
 * singleton wrapper around scanner
 *
 * @author schroeder
 * @date 07. Jul 2016
 */
public class ScannerUtil {

    private static Scanner scannerInstance;

    public static final Scanner getScanner() {

        if ( scannerInstance == null ) {
            scannerInstance = new Scanner(System.in);
        }
        return scannerInstance;
    }
}
