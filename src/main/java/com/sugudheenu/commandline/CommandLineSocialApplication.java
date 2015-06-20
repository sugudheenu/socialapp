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
            String line = scanner.nextLine();
            if (line.equals("Alice")) {
                System.out.println("It's a good day. (1 min ago)");
                System.out.println("I'm loving the beer! (1 min ago)");
            }
            displayPrompt();
        }
    }

    private void displayPrompt() {
        System.out.print("> ");
        System.out.flush();
    }
}
