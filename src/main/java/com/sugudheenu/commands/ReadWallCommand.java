package com.sugudheenu.commands;

import com.sugudheenu.domain.User;
import com.sugudheenu.ports.repository.Wall;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class ReadWallCommand implements Command {

    private final User user;
    private final Wall wall;

    public ReadWallCommand(User user, Wall wall) {
        this.user = user;
        this.wall = wall;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        consumer.accept(wall.getPosts(user).stream().map((it) -> it.get())
                .collect(toList()));
    }
}
