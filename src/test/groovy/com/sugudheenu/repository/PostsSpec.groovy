package com.sugudheenu.repository

import com.sugudheenu.domain.Post
import com.sugudheenu.domain.User
import spock.lang.Specification

import java.time.Instant

import static com.sugudheenu.domain.Post.post
import static com.sugudheenu.domain.User.user
import static java.time.Instant.now

class PostsSpec extends Specification {
    def postsRepository =  new InMemoryPosts();

    def "returns nothing when no posts are available for the user" () {
        when:
            def posts = postsRepository.get(user("Dinesh"))
        then:
            assert posts == []
    }

    def "returns posts in the most recent order"() {
        given:
            postsRepository.post(alice(), post("5MinsAgo", minutesAgo(5)))
            postsRepository.post(alice(), post("2MinsAgo", minutesAgo(2)))
            postsRepository.post(alice(), post("3MinsAgo", minutesAgo(3)))
        when:
            List<Post> posts = postsRepository.get(alice())
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
