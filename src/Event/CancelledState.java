package Event;

public class CancelledState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {

        System.out.println("Event was cancelled");
    }
    @Override
    public void cancel(Event event) {
        // already cancelled — no-op
    }
    @Override
    public void startEvent(Event event) {
        System.out.println("Cannot start a cancelled event");
    }
    @Override
    public void closeRegistration(Event event) {

        System.out.println("Event was cancelled");
    }
    @Override
    public String getName() { return "CANCELLED"; }
}