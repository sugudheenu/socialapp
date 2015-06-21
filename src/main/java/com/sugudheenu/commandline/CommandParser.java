package com.sugudheenu.commandline;

import com.sugudheenu.commands.Command;
import com.sugudheenu.commands.GetUserTimeLineCommand;
import com.sugudheenu.domain.User;
import com.sugudheenu.repository.TimeLine;

public class CommandParser {
    private TimeLine timeLine;

    public CommandParser(TimeLine timeLine) {
        this.timeLine = timeLine;
    }

    public Command parse(String input) {
        return new GetUserTimeLineCommand(User.user(input), timeLine);
   }
}
