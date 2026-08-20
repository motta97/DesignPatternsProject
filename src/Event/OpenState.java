package Event;

public class OpenState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        if (event.getRegisteredCount() >= event.getCapacity()) {
            System.out.println("Event is full");
        }
        event.register(attendee);
        if (event.getRegisteredCount() >= event.getCapacity()) {
            event.setState(new FullState());
        }
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
    public String getName() { return "OPEN"; }
}