package com.sugudheenu.repository;

import com.sugudheenu.domain.Post;
import com.sugudheenu.domain.User;

import java.util.*;

public class InMemoryPosts implements Posts {
    private final Map<User, List<Post>> posts = new HashMap<>();

    @Override
    public void post(User user, Post post) {
        posts.computeIfAbsent(user, k -> new ArrayList<>()).add(post);
    }

    @Override
    public List<Post> get(User user) {
        List<Post> userPosts = posts.getOrDefault(user, new ArrayList<>());
        userPosts.sort((o1, o2) -> o2.getTimestamp().compareTo(o1.getTimestamp()));
        return userPosts;
    }
}
