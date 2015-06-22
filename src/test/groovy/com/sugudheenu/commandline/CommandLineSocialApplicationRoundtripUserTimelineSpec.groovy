package com.sugudheenu.commandline

class CommandLineSocialApplicationRoundTripUserTimeLineSpec extends CommandLineApplicationUserTimeLineBaseSpec {

    def "can read the posts that got written" () {
        given:
            bob().posts(post("I don't like working on Sundays!"))
        when:
            bob().viewsHisTimeLine()
        then:
            bob().canSee("I don't like working on Sundays! (Just Now)")
    }
}
