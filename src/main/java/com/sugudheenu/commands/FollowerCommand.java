package com.sugudheenu.commands;

import com.sugudheenu.domain.User;
import com.sugudheenu.repository.FollowerBackFill;
import com.sugudheenu.repository.Followers;

import java.util.List;
import java.util.function.Consumer;

public class FollowerCommand implements Command {
    private final User user;
    private final User userToFollow;
    private final Followers followers;
    private FollowerBackFill followerBackFill;

    public FollowerCommand(User user, User userToFollow, Followers followers, FollowerBackFill followerBackFill) {
        this.user = user;
        this.userToFollow = userToFollow;
        this.followers = followers;
        this.followerBackFill = followerBackFill;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        followers.follows(user, userToFollow);
        followerBackFill.backFill(user, userToFollow);
    }
}
