package com.sugudheenu.commandline
import com.sugudheenu.domain.Post
import com.sugudheenu.repository.InMemoryTimeLine

import java.time.Instant

import static com.sugudheenu.domain.User.user
import static java.lang.System.lineSeparator
import static java.time.Instant.now

class CommandLineApplicationUserTimeLineBaseSpec extends CommandLineSocialApplicationBaseSpec {
    def bob() {
        return new UserDsl("Bob", timeline)
    }

    def alice() {
        return new UserDsl("Alice", timeline)
    }

    def post(String message) {
        return new PostDsl(message, now())
    }

    class PostDsl {
        String message;
        Instant timestamp = now()
        PostDsl(String message, Instant timestamp) {
            this.message = message
            this.timestamp = timestamp
        }

        def aMinuteAgo() {
            return new PostDsl(message, now().minusSeconds(60))
        }

        Post getPost() {
            return Post.post(message, timestamp)
        }
    }

    class UserDsl {
        String name = ""
        InMemoryTimeLine timeLine

        UserDsl(String name,  InMemoryTimeLine timeLine) {
            this.name = name
            this.timeLine = timeLine
        }

        def hasPosts(PostDsl... messages) {
            messages.each { message ->
                timeLine.post(user(name), message.getPost())
            }
        }

        void canSee(String... expected) {
            def actual = output().split(lineSeparator())
                    .collect { it.replaceAll("> ", "") }
                    .findAll { !it.empty }
            assert actual == expected as List
        }

        def viewsTimeLineOf(UserDsl user) {
            commands.add(user.name)
            applicationReceivesCommand(*commands)
        }

        void canSeeNothing() {
            canSee()
        }

        def posts(PostDsl... postDsl) {
            commands.addAll(postDsl.collect { "$name -> $it.message" })
        }

        def viewsHisTimeLine() {
            commands.add(name)
            applicationReceivesCommand(*commands)
        }

        def follows(UserDsl userToFollow) {
            commands.add("$name follows $userToFollow.name")
        }


        def viewsHisWall() {
            commands.add("$name wall")
            applicationReceivesCommand(*commands)
        }
    }
}
