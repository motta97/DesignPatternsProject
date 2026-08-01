package EventMVC;

import Event.Event;
import Event.EventFactory;

import java.util.List;

public class EventRepository {
    private EventFactory eventFactory;
    private EventFileManager eventFileManager;
    private List<Event> eventList;
    public EventRepository() {
        eventFactory = new EventFactory();
        eventFileManager = EventFileManager.getInstance();
    }
    public void save(){
        eventFileManager.save(eventList);
    }
    public void load(){
        eventList=eventFileManager.load();
    }
    public List<Event> getAllEvents(){
        load();
        return eventList;
    }
    public void addEvent(Event event){
        eventList.add(event);
        save();
    }
    public boolean removeEvent(int eventID){
        Event event = getEvent(eventID);
        if(event!=null) {
            eventList.remove(event);
            save();
            return true;
        }
        return false;
    }
    public Event getEvent(int id){
        for(Event event:eventList){
            if(event.getEventID()==id){
                return event;
            }
        }
        return null;
    }
}
