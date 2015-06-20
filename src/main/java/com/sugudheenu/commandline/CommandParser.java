package com.sugudheenu.commandline;

import com.sugudheenu.commands.Command;
import com.sugudheenu.commands.GetUserPostsCommand;
import com.sugudheenu.repository.UsersPostRepository;

public class CommandParser {

    private UsersPostRepository usersPostRepository;

    public CommandParser(UsersPostRepository usersPostRepository) {
        this.usersPostRepository = usersPostRepository;
    }

    public Command parse(String input) {
        return new GetUserPostsCommand(input, usersPostRepository);
   }
}
