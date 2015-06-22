package com.sugudheenu.repository;

import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Here since I am using the in memory version, I am going to do the back fill inline
 * if this is a real service I will have some sort of queue to receive this messages and process
 * the back fill asynchronously
 */
public class FollowerBackFill {
    private Followers followers;
    private final TimeLine timeLine;
    private final Wall wall;

    public FollowerBackFill(Followers followers, TimeLine timeLine, Wall wall) {
        this.followers = followers;
        this.timeLine = timeLine;
        this.wall = wall;
    }

    public void backFill(User user, User userFollowing) {
       wall.post(user, timeLine.get(userFollowing).stream().map((post) -> new WallPost(userFollowing, post)).collect(Collectors.toList()));
    }

    public void writeToFollowersWall(User user, WallPost wallPost) {
        Set<User> followers = this.followers.getFollowers(user);
        followers.stream().forEach((follower) -> {wall.post(follower, Arrays.asList(wallPost));});
    }
}