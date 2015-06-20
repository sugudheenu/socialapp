package com.sugudheenu.acceptance

import com.sugudheenu.commandline.CommandLineSocialApplication
import com.sugudheenu.domain.Post
import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule
import org.junit.contrib.java.lang.system.TextFromStandardInputStream
import spock.lang.Specification

import java.time.Instant
import java.util.concurrent.ConcurrentHashMap

import static java.lang.System.lineSeparator
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream

class CommandLineSocialApplicationReadUserTimelineSpec extends Specification {
    def application
    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog()
    @Rule
    public final TextFromStandardInputStream input = emptyStandardInputStream()
    private Map<String,List<Post>> posts = new ConcurrentHashMap<>()

    def setup() {
        application = new CommandLineSocialApplication()
    }

    def "bob can view alice timeline"() {
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

        def hasPosts(String... message) {
            message.each {
                posts.computeIfAbsent(name, {k -> new ArrayList<Post>()}).add(new Post(it, Instant.now()))
            }
        }

        void canSee(String... posts) {
           assert output.log.split(lineSeparator()) == posts
        }

        def viewsTimelineOf(UserDsl user) {
              posts.get(user.name).each {
                  System.out.println(it.post());
              }
        }
    }
}
