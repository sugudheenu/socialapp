package com.sugudheenu.commands;

import com.sugudheenu.domain.User;
import com.sugudheenu.repository.Posts;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class GetUserPostsCommand implements Command {
    private final Posts posts;
    private User user;

    public GetUserPostsCommand(User user, Posts posts) {
        this.user = user;
        this.posts = posts;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        List<String> output = posts.get(user).stream().map((it) -> it.get())
                .collect(toList());
        consumer.accept(output);
    }
}
