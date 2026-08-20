package Event;

public interface EventState {
    void register(Event event, Attendant attendee);
    void cancel(Event event);
    void startEvent(Event event);
    void closeRegistration(Event event);
    String getName();
}