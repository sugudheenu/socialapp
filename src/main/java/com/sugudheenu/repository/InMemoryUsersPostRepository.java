package com.sugudheenu.repository;

import com.sugudheenu.domain.Post;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUsersPostRepository implements UsersPostRepository {

    private final Map<String,List<Post>> posts = new HashMap<>();

    @Override
    public void post(String user, String message) {
        posts.computeIfAbsent(user, k -> new ArrayList<>()).add(new Post(message, Instant.now()));
    }

    @Override
    public List<Post> getPosts(String user) {
        return posts.getOrDefault(user, new ArrayList<>());
    }

}
