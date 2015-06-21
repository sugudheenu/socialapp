package com.sugudheenu.repository;

import com.sugudheenu.domain.Post;
import com.sugudheenu.domain.User;

import java.util.List;

/**
 * Repository to store users posts
 */
public interface Posts {
    void post(User user, Post post);

    List<Post> getPosts(User user);
}
