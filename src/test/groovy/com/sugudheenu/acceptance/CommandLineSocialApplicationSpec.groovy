package com.sugudheenu.acceptance

import com.sugudheenu.commandline.CommandLineSocialApplication
import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule
import org.junit.contrib.java.lang.system.TextFromStandardInputStream
import spock.lang.Specification

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream

class CommandLineSocialApplicationSpec extends Specification {
    private static final String PROMPT = "> "
    public static final String EMPTY_COMMAND = ""
    def application
    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream input = emptyStandardInputStream()

    def setup() {
        application = new CommandLineSocialApplication()
    }

    def "starts up with a command prompt"() {
        when:
            applicationIsRunning()
        then:
            userCanSee(PROMPT);
    }

    def "application is listening to commands"() {
        when:
            userEnters(EMPTY_COMMAND, EMPTY_COMMAND)
            applicationIsRunning()
        then:
            userCanSee(PROMPT, PROMPT, PROMPT);
    }

    def userEnters(String... command) {
        input.provideLines(command)
    }

    void userCanSee(String... expected) {
        assert output.getLog() == expected.join()
    }

    def applicationIsRunning() {
        application.run()
    }
}
