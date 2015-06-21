package com.sugudheenu.domain;

import java.time.Instant;

public class Post {
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
        return message + " (Just Now)";
    }
}
