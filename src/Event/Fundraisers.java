package Event;

import Enums.EventType;

public class Fundraisers extends Event{
    public Fundraisers(String eventName, double eventCost, String eventDescription, int capacity){
        super(eventName, eventCost, eventDescription, capacity);
        eventType= EventType.FUNDRAISERS;
        super.setEventCost(1000);
    }
    public String getEventType(){
        return "FUNDRAISERS";
    }

}