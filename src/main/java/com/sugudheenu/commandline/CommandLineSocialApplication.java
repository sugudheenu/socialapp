package com.sugudheenu.commandline;

import java.util.Scanner;

/**
 * Command line social application
 */
public class CommandLineSocialApplication {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        displayPrompt();
        while(scanner.hasNextLine()) {
            scanner.nextLine();
            displayPrompt();
        }
    }

    private void displayPrompt() {
        System.out.print("> ");
        System.out.flush();
    }
}
