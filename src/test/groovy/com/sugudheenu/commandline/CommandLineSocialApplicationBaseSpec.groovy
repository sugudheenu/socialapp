package com.sugudheenu.commandline

import com.sugudheenu.repository.InMemoryPosts
import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule
import org.junit.contrib.java.lang.system.TextFromStandardInputStream
import spock.lang.Specification

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream

class CommandLineSocialApplicationBaseSpec extends Specification {
    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog()
    @Rule
    public final TextFromStandardInputStream input = emptyStandardInputStream()

    InMemoryPosts usersPosts
    CommandLineSocialApplication application

    def setup() {
        usersPosts = new InMemoryPosts()
        application = new CommandLineSocialApplication(usersPosts)
    }

    def output() {
        return output.getLog()
    }

    def applicationReceivesCommand(String... commands) {
        input.provideLines(commands)
        applicationStars()
    }

    def applicationStars() {
        application.run()
    }
}
