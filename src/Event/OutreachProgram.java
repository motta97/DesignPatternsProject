package Event;

import Enums.EventType;

public class OutreachProgram extends Event{
    public OutreachProgram(String eventName,  double eventCost, String eventDescription,  int capacity) {
        super(eventName, eventCost, eventDescription,  capacity);
        eventType= EventType.OUTREACH;
        super.setEventCost(500);
    }
    public String getEventType(){
        return "OUTREACH";
    }


}