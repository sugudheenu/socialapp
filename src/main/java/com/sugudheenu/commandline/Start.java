package com.sugudheenu.commandline;

import com.sugudheenu.ports.InMemoryTimeLine;

/**
 * Command line social application main
 */
public class Start {
    public static void main(String[] args) {
        new CommandLineSocialApplication(new InMemoryTimeLine()).run();
    }
}
