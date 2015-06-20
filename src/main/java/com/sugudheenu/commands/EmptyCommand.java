package com.sugudheenu.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EmptyCommand implements Command {
    @Override
    public void execute(Consumer<List<String>> consumer) {
        consumer.accept(new ArrayList<>());
    }
}
