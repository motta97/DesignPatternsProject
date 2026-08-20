package Event;
import Enums.EventType;

import java.time.LocalDateTime;
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
    private int EventCapcity;
    private int registredCount = 0;
    private LocalDateTime schedule;
    public Event(String eventName, double eventCost, String eventDescription, int EventCapcity) {
        this.eventName=eventName;
        this.eventID=nextID++;
        this.eventCost=eventCost;
        this.eventDescription=eventDescription;
        this.EventCapcity=EventCapcity;
        currentState = new DraftState();
    }
    public LocalDateTime getSchedule() {
        return schedule;
    }
    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }
    public int getRegisteredCount() {
        return registredCount;
    }
    public int getCapacity() {
        return EventCapcity;
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
    public void setID(int eventID){
        this.eventID=eventID;
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
        reminderStrategy.sendReminder(this, attendant);
    }
    public String getEventDescription(){
        return eventDescription;
    }
    public void register(Attendant attendant){
        attendantList.add(attendant);
        registredCount++;
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