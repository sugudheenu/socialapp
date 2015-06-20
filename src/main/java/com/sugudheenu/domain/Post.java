package com.sugudheenu.domain;

import java.time.Instant;

public class Post {
    private final String message;
    private final Instant timestamp;

    public Post(String message, Instant timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String feedEntry() {
        return message + " (1 min ago)";
    }
}
