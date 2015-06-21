package com.sugudheenu.common
import spock.lang.Specification
import spock.lang.Unroll

import static TimeDifferenceTextFormatter.timeDifferenceAsText
import static java.time.Instant.now

class TimeDifferenceTextFormatterSpec extends Specification {

    @Unroll
    def "formats #seconds seconds before current time as #expectedText"() {
        expect:
           assert timeDifferenceAsText(now().minusSeconds(seconds)) == expectedText
        where:
            seconds | expectedText
            0       | "Just Now"
            1       | "1 second ago"
            2       | "2 seconds ago"
            59      | "59 seconds ago"
            60      | "1 minute ago"
            120     | "2 minutes ago"
            3540    | "59 minutes ago"
            3600    | "1 hour ago"
            7200    | "2 hours ago"
            86399   | "23 hours ago"
            86400   | "1 day ago"
            172800  | "2 days ago"

    }
}
