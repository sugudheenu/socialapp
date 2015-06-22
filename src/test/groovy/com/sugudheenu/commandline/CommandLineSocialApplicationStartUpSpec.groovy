package com.sugudheenu.commandline

class CommandLineSocialApplicationStartUpSpec extends CommandLineSocialApplicationBaseSpec {
    private static final String PROMPT = "> "
    public static final String EMPTY_COMMAND = ""

    def "starts up with a command prompt"() {
        when:
            applicationStarts();
        then:
            userCanSee(PROMPT);
    }

    def "application is listening to commands"() {
        when:
            userEnters(EMPTY_COMMAND, EMPTY_COMMAND)
        then:
            userCanSee(PROMPT, PROMPT, PROMPT);
    }

    def userEnters(String... input) {
        commands.addAll(input)
        applicationReceivesCommand()
    }

    void userCanSee(String... expected) {
        assert output() == expected.join()
    }
}
