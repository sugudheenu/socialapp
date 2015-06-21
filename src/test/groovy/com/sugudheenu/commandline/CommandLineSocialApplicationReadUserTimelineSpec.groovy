package com.sugudheenu.commandline

import com.sugudheenu.domain.User

import java.time.Instant

import static com.sugudheenu.domain.Post.post
import static java.lang.System.lineSeparator

class CommandLineSocialApplicationReadUserTimelineSpec extends CommandLineSocialApplicationBaseSpec {

    def "user can read multiple posts from timeline"() {
        given:
            alice().hasPosts("It's a good day.","I'm loving the beer!")
        when:
            bob().viewsTimelineOf(alice())
        then:
            bob().canSee("It's a good day. (Just Now)", "I'm loving the beer! (Just Now)")
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
                usersPosts.post(User.user(name), post(message, Instant.now()))
            }
        }

        void canSee(String... posts) {
           assert output().split(lineSeparator()).collect {it.replaceAll("> ","")}.findAll {!it.empty} == posts as List
        }

        def viewsTimelineOf(UserDsl user) {
            applicationReceivesCommand(user.name)
        }

        void canSeeNothing() {
            canSee()
        }
    }
}
