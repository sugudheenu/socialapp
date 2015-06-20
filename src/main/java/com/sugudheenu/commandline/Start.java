package com.sugudheenu.commandline;

import java.util.Scanner;

/**
 * Command line social application
 */
public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
