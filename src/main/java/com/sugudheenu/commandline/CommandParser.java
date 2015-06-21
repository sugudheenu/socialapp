package com.sugudheenu.commandline;

import com.sugudheenu.commands.Command;
import com.sugudheenu.commands.GetUserPostsCommand;
import com.sugudheenu.domain.User;
import com.sugudheenu.repository.Posts;

public class CommandParser {
    private Posts posts;

    public CommandParser(Posts posts) {
        this.posts = posts;
    }

    public Command parse(String input) {
        return new GetUserPostsCommand(User.user(input), posts);
   }
}
