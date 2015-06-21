package com.sugudheenu.domain;

public class User {
    private final String user;

    private User(String user) {
        this.user = user;
    }

    public static User user(String name) {
        return new User(name);
    }

    public String getUser() {
        return user;
    }
}
