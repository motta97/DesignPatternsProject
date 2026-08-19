package Event;

import Enums.EventType;

public class Workshop extends Event{
    public Workshop(String eventName, double eventCost, String eventDescription, int capacity) {
        super(eventName, eventCost, eventDescription,  capacity);
        eventType= EventType.WORKSHOP;
        super.setEventCost(900);
    }
    public String getEventType(){
        return "WORKSHOP";
    }
}
