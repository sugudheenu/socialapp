package com.sugudheenu.commands;

import com.sugudheenu.domain.User;
import com.sugudheenu.repository.TimeLine;

import java.util.List;
import java.util.function.Consumer;

import static com.sugudheenu.domain.Post.post;
import static java.time.Instant.now;

public class PostUsersTimeLineCommand implements Command {
    private final User user;
    private final String message;
    private final TimeLine timeLine;

    public PostUsersTimeLineCommand(User user, String message, TimeLine timeLine) {
        this.user = user;
        this.message = message;
        this.timeLine = timeLine;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        timeLine.post(user, post(message, now()));
    }
}
