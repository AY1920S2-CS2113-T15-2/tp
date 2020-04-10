package seedu.commands;

import seedu.events.Event;
import seedu.exception.EscException;
import seedu.subjects.SubjectList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Command class for the ShowUpcomingCommand.
 */
public class ShowUpcomingCommand extends Command {

    public static final String COMMAND_WORD = "showupcoming";

    public static final String MESSAGE_USAGE = "To show upcoming events, "
            + "type command: showupcoming d/[NUMBER OF DAYS UPCOMING]";

    private int dateRange;

    /**
     * Initialises the parameters for showupcoming command.
     */
    public ShowUpcomingCommand(int dateRange) {
        this.dateRange = dateRange;
    }

    /**
     * Show all upcoming events.
     */
    @Override
    public void execute(SubjectList subjectList) throws EscException {
        ArrayList<Event> events = subjectList.getEvents();
        ArrayList<Event> upcomingEvents = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Event event : events) {
            LocalDate date = event.getDate();
            long period = today.until(date, ChronoUnit.DAYS);
            if (period <= dateRange && period >= 0) {
                upcomingEvents.add(event);
            }
        }
        Collections.sort(upcomingEvents);
        subjectList.listUpcoming(upcomingEvents);
    }

}
