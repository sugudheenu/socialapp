package com.sugudheenu.commandline

import static com.sugudheenu.domain.Post.post
import static com.sugudheenu.domain.User.user
import static java.lang.System.lineSeparator
import static java.time.Instant.now

class CommandLineSocialApplicationReadUserTimelineSpec extends CommandLineSocialApplicationBaseSpec {

    def "user can read multiple posts from timeline"() {
        given:
            alice().hasPosts("It's a good day.","I'm loving the beer!")
        when:
            bob().viewsTimelineOf(alice())
        then:
            bob().canSee("I'm loving the beer! (Just Now)", "It's a good day. (Just Now)")
    }

    def "empty timeline for a user results with nothing" () {
        when:
            alice().viewsTimelineOf(bob())
        then:
            alice().canSeeNothing()
    }

    def bob() {
        return new UserDsl(name: "Bob")
    }

    def alice() {
        return new UserDsl(name: "Alice")
    }

    class UserDsl {
        String name = ""

        def hasPosts(String... messages) {
            messages.each { message ->
                timeline.post(user(name), post(message, now()))
            }
        }

        void canSee(String... posts) {
           assert output().split(lineSeparator())
                   .collect {it.replaceAll("> ","")}
                   .findAll {!it.empty} == posts as List
        }

        def viewsTimelineOf(UserDsl user) {
            applicationReceivesCommand(user.name)
        }

        void canSeeNothing() {
            canSee()
        }
    }
}
