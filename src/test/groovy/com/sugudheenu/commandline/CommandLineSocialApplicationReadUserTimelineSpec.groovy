package com.sugudheenu.commandline

import com.sugudheenu.domain.Post

import java.time.Instant

import static com.sugudheenu.domain.User.user
import static java.lang.System.lineSeparator
import static java.time.Instant.now

class CommandLineSocialApplicationReadUserTimelineSpec extends CommandLineSocialApplicationBaseSpec {

    def "user can read multiple posts from timeline"() {
        given:
            alice().hasPosts(post("I'm loving the beer!"), post("It's a good day.").aMinuteAgo())
        when:
            bob().viewsTimelineOf(alice())
        then:
            bob().canSee("I'm loving the beer! (Just Now)", "It's a good day. (1 minute ago)")
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

    def post(String message) {
        return new PostDsl(message: message)
    }

    class PostDsl {
        String message = ""
        Instant timestamp = now()

        def aMinuteAgo() {
            return new PostDsl(message: message, timestamp: now().minusSeconds(60))
        }

        Post getPost() {
            return Post.post(message, timestamp)
        }
    }

    class UserDsl {
        String name = ""

        def hasPosts(PostDsl... messages) {
            messages.each { message ->
                timeline.post(user(name), message.getPost())
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
