package Event;

import Enums.EventType;

public class EventFactory {
    private static Event event;
    public static Event createEvent(String eventName, String eventType, String eventState, double eventCost,
                                    String eventDescription, int capacity) {
        if(eventType.equals("FUNDRAISERS")){
            event = new Fundraisers(eventName, eventCost, eventDescription, capacity);
        }
        else if(eventType.equals("OUTREACH")){
            event= new OutreachProgram(eventName,  eventCost, eventDescription, capacity);
        }
        else if(eventType.equals("WORKSHOP")){
            event = new Workshop(eventName,  eventCost, eventDescription, capacity);
        }
        else{
            return event; //null
        }

        if(eventState.equals("DRAFT")){
            event.setState(new DraftState());
        }
        else if(eventState.equals("ONGOING")){
            event.setState(new OngoingState());
        }
        else if(eventState.equals("CLOSED")){
            event.setState(new ClosedState());
        }
        else if(eventState.equals("OPEN")){
            event.setState(new OpenState());
        }
        else if(eventState.equals("FULL")){
            event.setState(new FullState());
        }
        else if(eventState.equals("CANCELLED")){
            event.setState(new CancelledState());
        }
        else{
            event.setState(new DraftState());
        }

        return event;
    }
}
