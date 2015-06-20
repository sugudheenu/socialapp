package com.sugudheenu.commandline;

import java.util.Scanner;

/**
 * Command line social application
 */
public class CommandLineSocialApplication {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        System.out.flush();
        while(scanner.hasNextLine()) {
            scanner.nextLine();
            System.out.print("> ");
            System.out.flush();
        }

    }
}
