package com.sugudheenu.commandline

class CommandLineSocialApplicationSpec extends CommandLineSocialApplicationBaseSpec {

    private static final String PROMPT = "> "
    public static final String EMPTY_COMMAND = ""

    def "starts up with a command prompt"() {
        when:
            applicationStars();
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
        applicationReceivesCommand(commands)
    }

    void userCanSee(String... expected) {
        assert output() == expected.join()
    }

}
