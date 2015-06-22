package com.sugudheenu.commands;

import com.sugudheenu.domain.User;
import com.sugudheenu.ports.FolloweNotifier;
import com.sugudheenu.repository.Followers;

import java.util.List;
import java.util.function.Consumer;

public class FollowerCommand implements Command {
    private final User user;
    private final User followingUser;
    private final Followers followers;
    private FolloweNotifier followerNotifier;

    public FollowerCommand(User user, User followingUser, Followers followers, FolloweNotifier followerNotifier) {
        this.user = user;
        this.followingUser = followingUser;
        this.followers = followers;
        this.followerNotifier = followerNotifier;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        followers.follows(user, followingUser);
        followerNotifier.notifyFollows(user, followingUser);
    }
}
