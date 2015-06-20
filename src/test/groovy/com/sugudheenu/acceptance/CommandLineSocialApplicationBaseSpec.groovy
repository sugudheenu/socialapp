package com.sugudheenu.acceptance

import com.sugudheenu.commandline.CommandLineSocialApplication
import com.sugudheenu.repository.InMemoryUsersPostRepository
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

    InMemoryUsersPostRepository usersPosts
    CommandLineSocialApplication application

    def setup() {
        usersPosts = new InMemoryUsersPostRepository()
        application = new CommandLineSocialApplication()
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
