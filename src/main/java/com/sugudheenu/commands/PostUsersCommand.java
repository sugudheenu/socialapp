package com.sugudheenu.commands;

import com.sugudheenu.domain.Post;
import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;
import com.sugudheenu.ports.FollowerNotifier;
import com.sugudheenu.repository.TimeLine;
import com.sugudheenu.repository.Wall;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static com.sugudheenu.domain.Post.post;
import static java.time.Instant.now;

public class PostUsersCommand implements Command {
    private final User user;
    private final String message;
    private final TimeLine timeLine;
    private Wall wall;
    private FollowerNotifier followerNotifier;

    public PostUsersCommand(User user, String message, TimeLine timeLine, Wall wall, FollowerNotifier followerNotifier) {
        this.user = user;
        this.message = message;
        this.timeLine = timeLine;
        this.wall = wall;
        this.followerNotifier = followerNotifier;
    }

    @Override
    public void execute(Consumer<List<String>> consumer) {
        Post post = post(message, now());
        timeLine.post(user, post);
        WallPost wallPost = new WallPost(user, post);
        postToUsersOwnWall(wallPost);
        postToFollowersWall(wallPost);
    }

    private void postToFollowersWall(WallPost wallPost) {
        followerNotifier.notifyUserPost(user, wallPost);
    }

    private void postToUsersOwnWall(WallPost wallPost) {
        wall.post(user, Arrays.asList(wallPost));
    }
}
