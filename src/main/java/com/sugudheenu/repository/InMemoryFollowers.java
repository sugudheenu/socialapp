package com.sugudheenu.repository;

import com.sugudheenu.domain.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryFollowers implements Followers {
    private Map<User,Set<User>> followers = new HashMap<>();
    @Override
    public void follows(User user, User userToFollow) {
        followers.computeIfAbsent(user, k -> new HashSet<>()).add(userToFollow);
    }
}
