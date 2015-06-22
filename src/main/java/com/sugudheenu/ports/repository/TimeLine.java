package com.sugudheenu.ports.repository;

import com.sugudheenu.domain.Post;
import com.sugudheenu.domain.User;

import java.util.List;

/**
 * Repository to store users posts
 */
public interface TimeLine {
    void post(User user, Post post);

    List<Post> get(User user);
}
