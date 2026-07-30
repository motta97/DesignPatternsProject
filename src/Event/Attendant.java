package Event;
import BeneficaryManagement.User;
public class Attendant extends User implements EventObserver{
    private Event event;
    public Attendant(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
        event.registerObserver(this);

    }
    public void updateEventObserver(String eventNotification){
        System.out.println("User " + getName() + " received: " + eventNotification);
    }


}