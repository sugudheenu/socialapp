package com.sugudheenu.commandline;

import com.sugudheenu.commands.Command;
import com.sugudheenu.commands.GetUserTimeLineCommand;
import com.sugudheenu.commands.PostUsersTimeLineCommand;
import com.sugudheenu.domain.User;
import com.sugudheenu.repository.TimeLine;

public class CommandParser {
    private TimeLine timeLine;

    public CommandParser(TimeLine timeLine) {
        this.timeLine = timeLine;
    }

    public Command parse(String input) {
        if (input.contains("->")) {
            String[] args = input.split("->");
            return new PostUsersTimeLineCommand(User.user(args[0].trim()), args[1].trim(), timeLine);
        }
        return new GetUserTimeLineCommand(User.user(input.trim()), timeLine);
   }
}
