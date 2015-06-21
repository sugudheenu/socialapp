package com.sugudheenu.repository;

import com.sugudheenu.domain.Post;

import java.util.List;

/**
 * Repository to store users posts
 */
public interface UsersPostRepository {
    void post(String user, Post post);

    List<Post> getPosts(String user);
}
