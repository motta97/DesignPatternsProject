package Event;

import Enums.EventType;

public class Fundraisers extends Event{
    public Fundraisers(String eventName){
        super(eventName);
        eventType= EventType.FUNDRAISERS;
        super.setEventCost(1000);
    }

}