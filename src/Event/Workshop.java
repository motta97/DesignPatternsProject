package Event;

import Enums.EventType;

public class Workshop extends Event{
    public Workshop(String eventName) {
        super(eventName);
        eventType= EventType.WORKSHOP;
        super.setEventCost(900);
    }
}
