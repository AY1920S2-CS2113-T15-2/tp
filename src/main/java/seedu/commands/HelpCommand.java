package seedu.commands;

import seedu.cards.CardList;
import seedu.duke.Duke;
import seedu.duke.UI;

/**
 * Command class for the Help Command.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    /**
     * Displays the help menu.
     */
    @Override
    public void execute(CardList cards) {
        UI.printHelp();
    }
}
