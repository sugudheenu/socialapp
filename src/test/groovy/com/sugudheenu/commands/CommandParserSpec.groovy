package com.sugudheenu.commands
import com.sugudheenu.commandline.CommandParser
import com.sugudheenu.domain.Post
import com.sugudheenu.repository.UsersPostRepository
import spock.lang.Specification

import static java.time.Instant.now

class CommandParserSpec extends Specification {

    UsersPostRepository usersPostRepository = Mock()
    def commandParser = new CommandParser(usersPostRepository)

    def "empty command results with nothing"() {
        expect:
            commandParser.parse(emptyCommand()).execute({
                assert it == []
            })
    }

    def "read command returns user posts"() {
        given:
            usersPostRepository.getPosts("Alice") >> [new Post('post1', now()), new Post('post2', now())]
        expect:
            commandParser.parse("Alice").execute({
                assert it == ['post1 (Just Now)', 'post2 (Just Now)']
            })
    }


    private String emptyCommand() {
        return ""
    }
}
