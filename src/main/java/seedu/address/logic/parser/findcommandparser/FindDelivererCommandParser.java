package seedu.address.logic.parser.findcommandparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.function.Predicate;

import seedu.address.logic.commands.findcommands.FindCommand;
import seedu.address.logic.commands.findcommands.FindDelivererCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.PredicateParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Buyer;
import seedu.address.model.person.Deliverer;
import seedu.address.model.person.Supplier;

/**
 * Parses input arguments and creates a new FindCommand object.
 */
public class FindDelivererCommandParser implements Parser<FindCommand> {
    public static final String PARSE_WORD = "find-d";

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public FindDelivererCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        Predicate<Buyer> buyerPredicate = new Predicate<Buyer>() {
            @Override
            public boolean test(Buyer buyer) {
                return false;
            }
            public boolean equals(Object object) {
                return object instanceof Predicate;
            }
        };
        Predicate<Deliverer> delivererPredicate = PredicateParser.parseDeliverer(trimmedArgs);
        Predicate<Supplier> supplierPredicate = new Predicate<Supplier>() {
            @Override
            public boolean test(Supplier supplier) {
                return false;
            }
            public boolean equals(Object object) {
                return object instanceof Predicate;
            }
        };

        return new FindDelivererCommand(buyerPredicate, delivererPredicate, supplierPredicate);
    }
}
