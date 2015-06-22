package com.sugudheenu.repository;

import com.sugudheenu.domain.User;

import java.util.Set;

public interface Followers {

    void follows(User user, User userToFollow);

    Set<User> getFollowers(User user);
}
