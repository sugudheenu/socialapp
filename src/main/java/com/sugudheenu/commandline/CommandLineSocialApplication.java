package com.sugudheenu.commandline;

import com.sugudheenu.adaptors.repository.InMemoryFollowers;
import com.sugudheenu.adaptors.repository.InMemoryWall;
import com.sugudheenu.ports.repository.TimeLine;

import java.util.Scanner;

/**
 * Command line social application.
 */
public class CommandLineSocialApplication {
    private final CommandParser commandParser;

    public CommandLineSocialApplication(TimeLine timeLine) {
        commandParser = new CommandParser(timeLine, new InMemoryFollowers(), new InMemoryWall());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        displayPrompt();
        while(scanner.hasNextLine()) {
            commandParser.parse(scanner.nextLine()).execute((output) -> output.forEach(this::displayOutput));
            displayPrompt();
        }
    }

    private void displayOutput(String output) {
        System.out.println(output);
    }

    private void displayPrompt() {
        System.out.print("> ");
        System.out.flush();
    }
}
