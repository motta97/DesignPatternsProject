package Event;

public class CancelledState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        throw new IllegalStateException("Event was cancelled");
    }
    @Override
    public void cancel(Event event) {
        // already cancelled — no-op
    }
    @Override
    public void startEvent(Event event) {
        throw new IllegalStateException("Cannot start a cancelled event");
    }
    @Override
    public void closeRegistration(Event event) {
        throw new IllegalStateException("Event was cancelled");
    }
    @Override
    public String getName() { return "CANCELLED"; }
}