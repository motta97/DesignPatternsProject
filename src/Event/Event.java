package Event;
import Enums.EventType;

import java.util.List;

public abstract class Event implements Subject, Component {
    private String eventName="DEFAULT NAME";
    private int eventID;
    private double eventCost;
    private static int nextID=0;
    private List<EventObserver> eventObservers;
    private List<Attendant> attendantList;
    private List<Ticket> ticketList;
    private ReminderStrategy reminderStrategy;
    private String eventDescription;
    protected EventType eventType;
    private EventState currentState;
    public Event(String eventName, double eventCost, String eventDescription) {
        this.eventName=eventName;
        this.eventID=nextID++;
        this.eventCost=eventCost;
        this.eventDescription=eventDescription;
        currentState = new DraftState();
    }
    public int getEventID(){
        return eventID;
    }
    public double getEventCost(){
        return eventCost;
    }
    public void setEventCost(double eventCost){
        this.eventCost=eventCost;
    }
    public double getCost(){
        return eventCost;
    }
    public String getEventName(){
        return eventName;
    }
    public void registerObserver(EventObserver observer){
        eventObservers.add(observer);
    }
    public void removeObserver(EventObserver observer){
        eventObservers.remove(observer);
    }
    public void notifyObservers(String eventNotification){
        for(EventObserver o: eventObservers){
            o.updateEventObserver(eventNotification);
        }
    }

    public void ticket(Attendant attendant){
        Ticket ticket = new Ticket();
        ticket.addTicket(attendant, this);
        ticketList.add(ticket);
    }
    public List<Attendant> getAttendantList(){
        return attendantList;
    }
    public List<Ticket> getTicketList(){
        return ticketList;
    }
    public  void setEventDescription(String eventDescription){
        this.eventDescription=eventDescription;
    }
    public String getDescription(){
        return eventDescription;
    }
    public abstract String getEventType();
    public void setReminderStrategy(ReminderStrategy strategy){
        this.reminderStrategy=strategy;
    }
    public void sendReminder(Attendant attendant){
        reminderStrategy.sendReminder(attendant);
    }

    public void register(Attendant attendant){
        attendantList.add(attendant);
    }
    public void startEvent(){
        currentState.startEvent(this);
    }
    public void cancel(){
        currentState.cancel(this);
    }
    public void closeRegistration(){
        currentState.closeRegistration(this);
    }
    public String getEventState(){
        return currentState.getName();
    }
    public void setState(EventState state){
        currentState=state;
    }

    

}