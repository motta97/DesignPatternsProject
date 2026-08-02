package Event;

import Enums.EventType;

public class OutreachProgram extends Event{
    public OutreachProgram(String eventName){
        super(eventName);
        eventType= EventType.OUTREACH;
        super.setEventCost(500);
    }


}