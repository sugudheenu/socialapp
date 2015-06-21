package com.sugudheenu.repository;

import com.sugudheenu.domain.Post;
import com.sugudheenu.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUsersPostRepository implements UsersPostRepository {
    private final Map<String,List<Post>> posts = new HashMap<>();

    @Override
    public void post(User user, Post post) {
        posts.computeIfAbsent(user.getUser(), k -> new ArrayList<>()).add(post);
    }

    @Override
    public List<Post> getPosts(String user) {
        return posts.getOrDefault(user, new ArrayList<>());
    }
}
