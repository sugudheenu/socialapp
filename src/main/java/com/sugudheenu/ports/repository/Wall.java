package com.sugudheenu.ports.repository;

import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;

import java.util.List;

/**
 * Repository for users wall
 */
public interface Wall {
    List<WallPost> getPosts(User user);

    void post(User user, List<WallPost> posts);
}
