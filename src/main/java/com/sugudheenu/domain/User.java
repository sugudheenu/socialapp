package com.sugudheenu.domain;

public class User {
    private final String name;

    private User(String name) {
        this.name = name;
    }

    public static User user(String name) {
        return new User(name.trim());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user1 = (User) o;

        return !(name != null ? !name.equals(user1.name) : user1.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
