package com.sugudheenu.ports;

import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;
import com.sugudheenu.repository.Wall;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class InMemoryWall implements Wall {
    Map<User,Set<WallPost>> wall = new HashMap<>();

    @Override
    public List<WallPost> getPosts(User user) {
        return wall.getOrDefault(user, new HashSet<>()).stream()
                .sorted((o1, o2) -> o2.compareTo(o1)).collect(toList());
    }

    @Override
    public void post(User user, List<WallPost> posts) {
        posts.forEach((it) -> wall.computeIfAbsent(user, k -> new HashSet<>()).add(it));
    }
}
