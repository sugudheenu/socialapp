package com.sugudheenu.commandline

class CommandLineSocialApplicationReadUserTimeLineSpec extends CommandLineApplicationUserTimeLineBaseSpec {

    def "user can read multiple posts from timeline"() {
        given:
            alice().hasPosts(post("I'm loving the beer!"), post("It's a good day.").aMinuteAgo())
        when:
            bob().viewsTimeLineOf(alice())
        then:
            bob().canSee("I'm loving the beer! (Just Now)", "It's a good day. (1 minute ago)")
    }

    def "empty timeline for a user results with nothing" () {
        when:
            alice().viewsTimeLineOf(bob())
        then:
            alice().canSeeNothing()
    }
}
