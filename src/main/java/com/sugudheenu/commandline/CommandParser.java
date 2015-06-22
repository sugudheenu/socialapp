package com.sugudheenu.commandline;

import com.sugudheenu.commands.*;
import com.sugudheenu.repository.FollowerBackFill;
import com.sugudheenu.repository.Followers;
import com.sugudheenu.repository.TimeLine;
import com.sugudheenu.repository.Wall;

import static com.sugudheenu.domain.User.user;

public class CommandParser {
    private final TimeLine timeLine;
    private final Followers followers;
    private final Wall wall;
    private final FollowerBackFill followerBackFill;

    public CommandParser(TimeLine timeLine, Followers followers, Wall wall) {
        this.timeLine = timeLine;
        this.followers = followers;
        this.wall = wall;
        followerBackFill = new FollowerBackFill(timeLine, wall);
    }

    public Command parse(String input) {
        if (input.contains("->")) {
            String[] args = input.split("->");
            return new PostUsersCommand(user(args[0]), args[1].trim(), timeLine, wall);
        } else if (input.contains("follows")) {
            String[] args = input.split("follows");
            return new FollowerCommand(user(args[0]), user(args[1]), followers, followerBackFill);
        } else if (input.contains("wall")) {
            String[] args = input.split("wall");
            return new ReadWallCommand(user(args[0]), wall);
        }

        return new GetUserTimeLineCommand(user(input.trim()), timeLine);
   }
}
