package Event;

import utility.User;

public class Attendant extends User implements EventObserver{
    private Event event;
    public Attendant(String name, String email, String phoneNumber, Event event){
        super(name, email, phoneNumber);
        this.event = event;
        event.registerObserver(this);
    }
    public Attendant(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);

    }
    public void updateEventObserver(String eventNotification){
        System.out.println("User " + getName() + " received: " + eventNotification);
    }


}