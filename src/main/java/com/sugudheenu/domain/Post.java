package com.sugudheenu.domain;

import java.time.Instant;

import static com.sugudheenu.common.TimeDifferenceTextFormatter.timeDifferenceAsText;

public class Post {
    private final String message;
    private final Instant timestamp;

    private Post(String message, Instant timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public static Post post(String message, Instant timestamp) {
        return new Post(message,timestamp);
    }

    public String get() {
        return String.format("%s (%s)",message, timeDifferenceAsText(timestamp));
    }
}
