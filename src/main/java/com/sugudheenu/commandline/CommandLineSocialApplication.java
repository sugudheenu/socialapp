package com.sugudheenu.commandline;

import com.sugudheenu.repository.UsersPostRepository;

import java.util.Scanner;

/**
 * Command line social application
 */
public class CommandLineSocialApplication {

    private final CommandParser commandParser;

    public CommandLineSocialApplication(UsersPostRepository usersPostRepository) {
        commandParser = new CommandParser(usersPostRepository);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        displayPrompt();
        while(scanner.hasNextLine()) {
            commandParser.parse(scanner.nextLine()).execute((output) -> {
                output.forEach((it) -> System.out.println(it));
            });
            displayPrompt();
        }
    }

    private void displayPrompt() {
        System.out.print("> ");
        System.out.flush();
    }
}
