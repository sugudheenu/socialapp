package com.sugudheenu.acceptance
import com.sugudheenu.acceptance.dsl.ApplicationDsl

import static java.lang.System.lineSeparator

class CommandLineSocialApplicationReadUserTimelineSpec extends CommandLineSocialApplicationBaseSpec implements ApplicationDsl {

    def "user can read multiple posts from timeline"() {
        given:
            alice().hasPosts("It's a good day.","I'm loving the beer!")
        when:
            bob().viewsTimelineOf(alice())
        then:
            bob().canSee("It's a good day. (1 min ago)", "I'm loving the beer! (1 min ago)")
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
                usersPosts.post(name, message)
            }
        }

        void canSee(String... posts) {
           assert output().split(lineSeparator()).collect {it.replaceAll("> ","")}.findAll {!it.empty} == posts as List
        }

        def viewsTimelineOf(UserDsl user) {
            applicationReceivesCommand(user.name)
        }

    }
}
