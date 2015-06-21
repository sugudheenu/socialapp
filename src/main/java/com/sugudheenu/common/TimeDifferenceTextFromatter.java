package com.sugudheenu.common;

import java.time.Duration;
import java.time.Instant;

import static java.time.Instant.now;

public class TimeDifferenceTextFromatter {
    public static String timeDifferenceAsText(Instant timestamp) {
        Duration duration = Duration.between(now(), timestamp).abs();
        long seconds = duration.getSeconds();
        if (seconds/60 >= 1) {
            return String.format("%d minute ago", duration.toMinutes());
        } else {
            return "Just Now";
        }
    }
}
