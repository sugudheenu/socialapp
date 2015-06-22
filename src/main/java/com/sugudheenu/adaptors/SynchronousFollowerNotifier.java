package com.sugudheenu.adaptors;

import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;
import com.sugudheenu.ports.FollowerNotifier;
import com.sugudheenu.ports.repository.Followers;
import com.sugudheenu.ports.repository.TimeLine;
import com.sugudheenu.ports.repository.Wall;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Since I am using the in memory version, I am going to do the back fill inline
 * if this is a real service I will have some sort of queue to receive this messages and process
 * the back fill asynchronously. This would probably be an interface and I would have tested if
 * the notification was received when the command gets executed.
 */
public class SynchronousFollowerNotifier implements FollowerNotifier {
    private Followers followers;
    private final TimeLine timeLine;
    private final Wall wall;

    public SynchronousFollowerNotifier(Followers followers, TimeLine timeLine, Wall wall) {
        this.followers = followers;
        this.timeLine = timeLine;
        this.wall = wall;
    }

    @Override
    public void notifyFollows(User user, User userFollowing) {
       wall.post(user, timeLine.get(userFollowing).stream().map((post) -> new WallPost(userFollowing, post)).collect(Collectors.toList()));
    }

    @Override
    public void notifyUserPost(User user, WallPost wallPost) {
        followers.getFollowers(user).stream().forEach((follower) -> {
            wall.post(follower, Arrays.asList(wallPost));
        });
    }
}