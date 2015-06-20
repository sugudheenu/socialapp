package com.sugudheenu.endtoend

import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule
import spock.lang.Specification

class CommandlineSocialApplicationSpec extends  Specification {

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();

    def "starts up with a command prompt" () {
        expect:
            applicationStartsUpWithPrompt("> ")
    }

    void applicationStartsUpWithPrompt(String expected) {
        System.out.print("> ")
        System.out.flush()
        assert  output.getLog() == expected
    }

}
