package Event;

public class OngoingState implements EventState {
    @Override
    public void register(Event event, Attendant attendee) {
        System.out.println("can't register, event already in progress");
    }
    @Override
    public void cancel(Event event) {

        System.out.println("can't cancel an event already in progress");
    }
    @Override
    public void startEvent(Event event) {

        System.out.println("event already started");
    }
    @Override
    public void closeRegistration(Event event) {
        //no operation
    }
    @Override
    public String getName() { return "ONGOING"; }
}
