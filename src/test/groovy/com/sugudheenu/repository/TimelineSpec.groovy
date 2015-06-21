package com.sugudheenu.repository

import com.sugudheenu.domain.Post
import com.sugudheenu.domain.User
import spock.lang.Specification

import java.time.Instant

import static com.sugudheenu.domain.Post.post
import static com.sugudheenu.domain.User.user
import static java.time.Instant.now

class TimeLineSpec extends Specification {
    def timeline =  new InMemoryTimeLine();

    def "returns nothing when no posts are available for the user" () {
        when:
            def posts = timeline.get(user("Dinesh"))
        then:
            assert posts == []
    }

    def "returns posts in the most recent order"() {
        given:
            timeline.post(alice(), post("5MinsAgo", minutesAgo(5)))
            timeline.post(alice(), post("2MinsAgo", minutesAgo(2)))
            timeline.post(alice(), post("3MinsAgo", minutesAgo(3)))
        when:
            List<Post> posts = timeline.get(alice())
        then:
            assert posts.collect { it.message } == ['2MinsAgo', '3MinsAgo', '5MinsAgo']
    }

    private Instant minutesAgo(def minutes) {
        return now().minusSeconds(minutes*60)
    }

    private User alice() {
        return user("Alice")
    }
}
