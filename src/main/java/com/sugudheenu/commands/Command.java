package com.sugudheenu.commands;

import java.util.List;
import java.util.function.Consumer;

public interface Command {
    void execute(Consumer<List<String>> consumer);
}
