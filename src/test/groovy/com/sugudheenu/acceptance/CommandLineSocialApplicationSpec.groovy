package com.sugudheenu.acceptance

import com.sugudheenu.commandline.CommandLineSocialApplication
import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule
import spock.lang.Specification

class CommandLineSocialApplicationSpec extends Specification {
    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();

    def "starts up with a command prompt"() {
        when:
            applicationStartsUp()
        then:
            iCanSee("> ");
    }

    void iCanSee(String expected) {
        assert output.getLog() == expected
    }

    def applicationStartsUp() {
        new CommandLineSocialApplication().run();
    }
}
