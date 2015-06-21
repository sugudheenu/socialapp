package com.sugudheenu.commands;

import com.sugudheenu.domain.User;
import com.sugudheenu.repository.TimeLine;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class GetUserTimeLineCommand implements Command {
    private final TimeLine timeLine;
    private User user;

    public GetUserTimeLineCommand(User user, TimeLine timeLine) {
        this.user = user;
        this.timeLine = timeLine;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        List<String> output = timeLine.get(user).stream().map((it) -> it.get())
                .collect(toList());
        consumer.accept(output);
    }
}
