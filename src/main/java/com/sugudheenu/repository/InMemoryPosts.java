package com.sugudheenu.repository;

import com.sugudheenu.domain.Post;
import com.sugudheenu.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class InMemoryPosts implements Posts {
    private final Map<User, List<Post>> posts = new HashMap<>();

    @Override
    public void post(User user, Post post) {
        posts.computeIfAbsent(user, k -> new ArrayList<>()).add(post);
    }

    @Override
    public List<Post> get(User user) {
        return posts.getOrDefault(user, new ArrayList<>()).stream()
                .sorted((post1, post2) -> post2.getTimestamp().compareTo(post1.getTimestamp()))
                .collect(toList());
    }
}
