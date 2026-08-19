package Event;

public class ClosedState implements EventState{
    @Override
    public void register(Event event, Attendant attendee) {
        // no operation
    }
    @Override
    public void cancel(Event event) {
        // no operation
    }
    @Override
    public void startEvent(Event event) {
        // no operation
    }
    @Override
    public void closeRegistration(Event event) {
        // no operation
    }
    @Override
    public String getName() { return "CLOSED"; }
}
