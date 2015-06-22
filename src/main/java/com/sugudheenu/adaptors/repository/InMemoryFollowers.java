package com.sugudheenu.adaptors.repository;

import com.sugudheenu.domain.User;
import com.sugudheenu.ports.repository.Followers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryFollowers implements Followers {
    private Map<User,Set<User>> followers = new HashMap<>();
    @Override
    public void follows(User user, User userToFollow) {
        followers.computeIfAbsent(userToFollow, k -> new HashSet<>()).add(user);
    }

    @Override
    public Set<User> getFollowers(User user) {
        return followers.getOrDefault(user, new HashSet<>());
    }
}
