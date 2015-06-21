package com.sugudheenu.domain;

public class User {
    private final String user;

    private User(String user) {
        this.user = user;
    }

    public static User user(String name) {
        return new User(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user1 = (User) o;

        return !(user != null ? !user.equals(user1.user) : user1.user != null);

    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }
}
