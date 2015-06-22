package com.sugudheenu.ports;

import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;

public interface FolloweNotifier {
    void notifyFollows(User user, User userFollowing);

    void notifyUserPost(User user, WallPost wallPost);
}
