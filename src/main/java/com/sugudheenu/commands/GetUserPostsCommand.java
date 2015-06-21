package com.sugudheenu.commands;

import com.sugudheenu.domain.User;
import com.sugudheenu.repository.UsersPostRepository;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class GetUserPostsCommand implements Command {
    private final UsersPostRepository usersPostRepository;
    private User user;

    public GetUserPostsCommand(User user, UsersPostRepository usersPostRepository) {
        this.user = user;
        this.usersPostRepository = usersPostRepository;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        List<String> output = usersPostRepository.getPosts(user).stream().map((it) -> it.get())
                .collect(toList());
        consumer.accept(output);
    }
}
