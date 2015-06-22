package com.sugudheenu.domain;

import java.time.Instant;

import static com.sugudheenu.common.TimeDifferenceTextFormatter.timeDifferenceAsText;

public class Post implements Comparable<Post> {
    private final String message;
    private final Instant timestamp;

    private Post(String message, Instant timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
    
    public static Post post(String message, Instant timestamp) {
        return new Post(message,timestamp);
    }

    public String get() {
        return String.format("%s (%s)",message, timeDifferenceAsText(timestamp));
    }

    @Override
    public int compareTo(Post otherPost) {
        return timestamp.compareTo(otherPost.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (message != null ? !message.equals(post.message) : post.message != null) return false;
        return !(timestamp != null ? !timestamp.equals(post.timestamp) : post.timestamp != null);

    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
