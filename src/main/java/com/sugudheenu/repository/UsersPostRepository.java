package com.sugudheenu.repository;

import com.sugudheenu.domain.Post;

import java.util.List;

/**
 * Repository to store users Feed
 */
public interface UsersPostRepository {

    void post(String user, String message);

    List<Post> getPosts(String user);

}
