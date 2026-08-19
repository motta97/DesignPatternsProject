package Event;

public class DraftState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        throw new IllegalStateException("Cannot register — event not published yet");
    }
    @Override
    public void cancel(Event event) {
        event.setState(new CancelledState());
    }
    @Override
    public void startEvent(Event event) {
        throw new IllegalStateException("Cannot start — event still in draft");
    }
    @Override
    public void closeRegistration(Event event) {
        throw new IllegalStateException("No registration to close — event is a draft");
    }
    @Override
    public String getName() { return "DRAFT"; }
}
