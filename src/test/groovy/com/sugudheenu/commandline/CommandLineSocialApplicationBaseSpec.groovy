package com.sugudheenu.commandline
import com.sugudheenu.ports.InMemoryTimeLine
import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule
import org.junit.contrib.java.lang.system.TextFromStandardInputStream
import spock.lang.Shared
import spock.lang.Specification

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream

class CommandLineSocialApplicationBaseSpec extends Specification {
    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog()
    @Rule
    public final TextFromStandardInputStream input = emptyStandardInputStream()

    InMemoryTimeLine timeline
    CommandLineSocialApplication application
    @Shared List<String> commands = new ArrayList<>();

    def setup() {
        timeline = new InMemoryTimeLine()
        application = new CommandLineSocialApplication(timeline)
    }

    def output() {
        return output.getLog()
    }

    def applicationReceivesCommand() {
        input.provideLines(*commands)
        applicationStarts()
    }

    def applicationStarts() {
        application.run()
    }
}
