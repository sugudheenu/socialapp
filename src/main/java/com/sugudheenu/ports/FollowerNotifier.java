package com.sugudheenu.ports;

import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;

/**
 * Service that listens to follower notifications
 */
public interface FollowerNotifier {
    void notifyFollows(User user, User userFollowing);

    void notifyUserPost(User user, WallPost wallPost);
}
