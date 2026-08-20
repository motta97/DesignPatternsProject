package Event;

public class DraftState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        System.out.println("Cannot register — event not published yet");
    }
    @Override
    public void cancel(Event event) {
        event.setState(new CancelledState());
    }
    @Override
    public void startEvent(Event event) {
        System.out.println("Cannot start — event still in draft");
    }
    @Override
    public void closeRegistration(Event event) {
        System.out.println("No registration to close — event is a draft");
    }
    @Override
    public String getName() { return "DRAFT"; }
}
