package com.sugudheenu.repository;

import com.sugudheenu.domain.User;

public interface Followers {

    void follows(User user, User userToFollow);


}
