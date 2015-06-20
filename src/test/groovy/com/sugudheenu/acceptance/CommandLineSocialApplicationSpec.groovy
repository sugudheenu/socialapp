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
    public final SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();
    @Rule
    public final TextFromStandardInputStream input = emptyStandardInputStream()

    def setup() {
        application = new CommandLineSocialApplication()
    }

    def "starts up with a command prompt"() {
        when:
            applicationStarts()
        then:
            userCanSee(PROMPT);
    }

    def "application is listening to commands"() {
        when:
            userEnters(EMPTY_COMMAND, EMPTY_COMMAND)
        then:
            userCanSee(PROMPT, PROMPT, PROMPT);
    }


    def userEnters(String... commands) {
        input.provideLines(commands)
        applicationStarts()
    }

    void userCanSee(String... expected) {
        assert output.getLog() == expected.join()
    }

    def applicationStarts() {
        application.run()
    }
}
