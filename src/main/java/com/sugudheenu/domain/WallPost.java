package com.sugudheenu.domain;

public class WallPost implements Comparable<WallPost> {
    private final User user;
    private final Post post;

    public WallPost(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public String get() {
        return String.format("%s - %s", user.getName(), post.get());
    }

    @Override
    public int compareTo(WallPost otherWallPost) {
        return post.compareTo(otherWallPost.post);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WallPost wallPost = (WallPost) o;

        if (user != null ? !user.equals(wallPost.user) : wallPost.user != null) return false;
        return !(post != null ? !post.equals(wallPost.post) : wallPost.post != null);

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (post != null ? post.hashCode() : 0);
        return result;
    }
}
