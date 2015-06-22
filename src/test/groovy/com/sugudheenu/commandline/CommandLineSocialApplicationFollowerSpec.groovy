package com.sugudheenu.commandline

class CommandLineSocialApplicationFollowerSpec extends CommandLineApplicationUserTimeLineBaseSpec {

    def "can view an aggregated list of all subscriptions" () {
        given:
            bob().posts(post("I don't like working on Sundays!"))
            alice().hasPosts(post("Wish Lewis won the race today").aMinuteAgo())
            bob().follows(alice())
            alice().posts(post("I am hungry..."))
        when:
            bob().viewsHisWall()
        then:
            bob().canSee("Alice - I am hungry... (Just Now)",
                    "Bob - I don't like working on Sundays! (Just Now)",
                    "Alice - Wish Lewis won the race today (1 minute ago)"
            )
    }
}
