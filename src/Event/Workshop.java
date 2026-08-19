package Event;

import Enums.EventType;

public class Workshop extends Event{
    public Workshop(String eventName, double eventCost, String eventDescription) {
        super(eventName, eventCost, eventDescription);
        eventType= EventType.WORKSHOP;
        super.setEventCost(900);
    }
    public String getEventType(){
        return "WORKSHOP";
    }
}
