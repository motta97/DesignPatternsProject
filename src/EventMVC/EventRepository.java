package EventMVC;

import Event.Event;
import Event.EventFactory;

import java.util.List;

public class EventRepository {
    private EventFactory eventFactory;
    private static EventFileManager eventFileManager;
    private List<Event> eventList;
    private static EventRepository uniqueInstance;
    private EventRepository() {
    }
    public static EventRepository getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new EventRepository();
            eventFileManager = EventFileManager.getInstance();
        }
        return uniqueInstance;
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
        load();
        eventList.add(event);
        save();
        System.out.println("I GOT HERE");
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
