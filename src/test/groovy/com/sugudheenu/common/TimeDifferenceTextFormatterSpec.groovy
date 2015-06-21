package com.sugudheenu.common
import spock.lang.Specification
import spock.lang.Unroll

import static TimeDifferenceTextFromatter.timeDifferenceAsText
import static java.time.Instant.now

class TimeDifferenceTextFormatterSpec extends Specification {

    @Unroll
    def "formats #seconds seconds before as #expectedText"() {
        expect:
           assert timeDifferenceAsText(now().minusSeconds(seconds)) == expectedText
        where:
            seconds | expectedText
            0       | "Just Now"
            60      | "1 minute ago"
    }
}
