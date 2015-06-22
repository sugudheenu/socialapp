package com.sugudheenu.repository;

import com.sugudheenu.domain.User;
import com.sugudheenu.domain.WallPost;

import java.util.List;

public interface Wall {
    List<WallPost> getPosts(User user);

    void post(User user, List<WallPost> posts);
}
