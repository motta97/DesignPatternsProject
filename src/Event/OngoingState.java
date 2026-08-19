package Event;

public class OngoingState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        throw new IllegalStateException("Cannot register — event already in progress");
    }
    @Override
    public void cancel(Event event) {
        throw new IllegalStateException("Cannot cancel an event already in progress");
    }
    @Override
    public void startEvent(Event event) {
        throw new IllegalStateException("Event already started");
    }
    @Override
    public void closeRegistration(Event event) {
        // no-op or already implied
    }
    @Override
    public String getName() { return "ONGOING"; }
}
