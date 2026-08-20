package Event;

import java.util.List;

public class EventIterator {
    private int position = 0;
    private List<Event> events;
    public EventIterator( List<Event> events ) {
        this.events = events;
    }
    public Event next(){
        if(position < events.size()){
            return events.get(position++);
        }
        return null;
    }
    public boolean hasNext(){
        return position < events.size();
    }
}
