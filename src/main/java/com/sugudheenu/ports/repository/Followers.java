package com.sugudheenu.ports.repository;

import com.sugudheenu.domain.User;

import java.util.Set;

/**
 * Repository for followers.
 */
public interface Followers {

    void follows(User user, User userToFollow);

    Set<User> getFollowers(User user);
}
