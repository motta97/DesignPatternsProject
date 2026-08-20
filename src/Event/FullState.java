package Event;

public class FullState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        System.out.println("can't register full state");
    }
    @Override
    public void cancel(Event event) {
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
