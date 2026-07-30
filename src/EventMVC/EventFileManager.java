package EventMVC;

import Event.Event;

import java.util.List;

public class EventFileManager {
    private List<Event> events;
    private static EventFileManager uniqueInstance;
    private EventFileManager() {}
    public static EventFileManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EventFileManager();
        }
        return uniqueInstance;
    }
    public List<Event> load(){
        //read from a text file and assign to events
        return events;

    }
    public  void save(){
        //save to a text file
    }

}
