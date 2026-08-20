package Event;

public class OngoingState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        throw new IllegalStateException("can't register, event already in progress");
    }
    @Override
    public void cancel(Event event) {
        throw new IllegalStateException("can't cancel an event already in progress");
    }
    @Override
    public void startEvent(Event event) {

        throw new IllegalStateException("event already started");
    }
    @Override
    public void closeRegistration(Event event) {
        //no operation
    }
    @Override
    public String getName() { return "ONGOING"; }
}
