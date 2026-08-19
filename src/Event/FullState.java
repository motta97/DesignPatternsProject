package Event;

public class FullState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        event.addToWaitlist(attendee); // different behavior than OpenState!
    }
    @Override
    public void cancel(Event event) {
        event.notifyAttendeesOfCancellation();
        event.setState(new CancelledState());
    }
    @Override
    public void startEvent(Event event) {
        event.setState(new OngoingState());
    }
    @Override
    public void closeRegistration(Event event) {
        event.setState(new ClosedState());
    }
    @Override
    public String getName() { return "FULL"; }
}
