package Event;

import Enums.EventType;

public class EventFactory {
    private Event event;
    public Event createEvent(EventType eventType, String eventName) {
        if(eventType.equals(EventType.FUNDRAISERS)){
            event = new Fundraisers(eventName);
        }
        else if(eventType.equals(EventType.OUTREACH)){
            event= new OutreachProgram(eventName);
        }
        else if(eventType.equals(EventType.WORKSHOP)){
            event = new Workshop(eventName);
        }
        return event;
    }
}
