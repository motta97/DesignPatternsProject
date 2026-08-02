package Event;
public class Ticket{
    private static int nextID=0;
    private int ticketID;
    private Attendant attendant;
    private Event event;
    public Ticket(){
                this.ticketID=nextID++;
    }
    public void addTicket(Attendant attendant, Event event){
        this.event=event;
        this.attendant=attendant;
    }
}