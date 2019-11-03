package seedu.address.diaryfeature.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.diaryfeature.logic.commands.DeleteCommand;
import seedu.address.diaryfeature.logic.commands.UnPrivateCommand;
import seedu.address.diaryfeature.logic.parser.exceptions.EmptyArgumentException;
import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.exceptions.ParseException;

public class UnPrivateCommandParser {
    public static final String UNPRIVATE_USAGE = "In particular, input your unprivate command like this: \n" +
            "unprivate target Eg: unprivate 1. \n Note that the input has to be more than or equal to 1";
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     *
     */
    public Command parse(String args) throws EmptyArgumentException {
        try {
            Index index;
            index = ParserUtil.parseIndex(args);
            return new UnPrivateCommand(index);
        } catch (ParseException error) {
            throw new EmptyArgumentException(UnPrivateCommand.COMMAND_WORD, UNPRIVATE_USAGE);
        }
    }
}

