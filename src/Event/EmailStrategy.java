package Event;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

public class EmailStrategy implements ReminderStrategy {

    @Override
    public String formatMessage(Event event, Attendant attendant) {
        String subject = generateSubjectLine(event);
        String body = renderHtmlBody(event, attendant);
        return subject + "|||" + body;
    }

    private String generateSubjectLine(Event event) {
        long hoursUntil = Duration.between(Instant.now(), event.getSchedule().toInstant(ZoneOffset.UTC)).toHours();
        if (hoursUntil <= 24) {
            return "Starting soon: " + event.getEventName();
        } else if (hoursUntil <= 72) {
            return "Reminder: " + event.getEventName() + " this week";
        }
        return "Upcoming: " + event.getEventName();
    }

    private String renderHtmlBody(Event event, Attendant attendant) {
        return "<h2>Hi " + attendant.getName() + "</h2>"
                + "<p>" + event.getEventName() + " is on " + event.getSchedule() + "</p>";
    }

    @Override
    public void deliver(String message, Attendant attendant) {

        EmailGateway.send(message,attendant);
    }
}