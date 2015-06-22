package com.sugudheenu.common;

import java.time.Duration;
import java.time.Instant;

import static java.time.Duration.between;
import static java.time.Instant.now;

/**
 * Utility class that computes time difference
 */
public class TimeDifferenceTextFormatter {

    /**
     * @param instant
     * @return time difference returned as text
     */
    public static String timeDifferenceAsText(Instant instant) {
        Duration duration = between(now(), instant).abs();
        if (duration.getSeconds() < 1) {
            return "Just Now";
        } else if (duration.getSeconds() < 60) {
            return  timeInText(duration.getSeconds(), "second");
        } else if (duration.toMinutes() < 60) {
            return  timeInText(duration.toMinutes(), "minute");
        } else if (duration.toHours() < 24) {
            return  timeInText(duration.toHours(), "hour");
        } else {
            return  timeInText(duration.toDays(), "day");
        }
    }

    private static String timeInText(long timeUnit, String timeUnitAsText) {
        return String.format("%d %s ago", timeUnit, timeUnit == 1 ? timeUnitAsText : timeUnitAsText+"s");
    }
}
