package com.sugudheenu.commands;

import com.sugudheenu.repository.UsersPostRepository;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class GetUserPostsCommand implements Command {
    private final String input;
    private final UsersPostRepository usersPostRepository;

    public GetUserPostsCommand(String input, UsersPostRepository usersPostRepository) {
        this.input = input;
        this.usersPostRepository = usersPostRepository;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        List<String> output = usersPostRepository.getPosts(input).stream().map((it) -> it.get())
                .collect(toList());
        consumer.accept(output);
    }
}
