package EventMVC;

import Enums.EventType;
import utility.User;
import Enums.ReminderType;
import Event.Event;
import Event.Attendant;
import Event.WhatsAppStrategy;
import Event.SMSStrategy;
import Event.EmailStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Event.EventFactory;

public class EventContoller {
    private EventRepository eventRepository;
    private UserRepository userRepoisitory;
    private EventView eventView;
    private EventFactory eventFactory;

    public EventContoller(){
        eventRepository = EventRepository.getInstance();
        userRepoisitory = new UserRepository();
        eventView = new EventView();
    }
    public void start(){

        eventView.showEventMainMenu();
        int choice = eventView.getInt("Menu Choice");
        process(choice);
    }
    public void process(int actionID){
        //we need to add print all users and print all events methods
        if(actionID==1){
            //create event
            eventView.showCreateEventMenu();
            String eventName= eventView.getString("EventName");
            String eventType = eventView.getString("EventType choose one of: Fundraisers, Outreach, or Workshop");
            String eventDescription = eventView.getString("EventDescription");
            double cost = eventView.getDouble("EventCost");
            int capacity = eventView.getInt("EventCapacity");
            String schedule = eventView.getString("EventDate in d/m/yyyy");
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate date = LocalDate.parse(schedule, fmt);
            LocalDateTime dateTime = date.atStartOfDay();
            int eventID= createEvent(eventName, eventType,cost, eventDescription, capacity, dateTime);
            if(eventID==-1){
                start();
            }
            else {
                eventView.showEventDetails(eventID);//should show the event details based on its id
                start();
            }

        }
       else if(actionID==2){
            //update an event
            eventView.showUpdateEventMenu();
            int eventID= eventView.getInt("Event ID");
            String eventDescription = eventView.getString("Event Description");
            boolean result =updateEvent(eventDescription, eventID);
            if(result){
                eventView.displayMessage("SUCCESS UPDATING EVENT");
            }
            else {
                eventView.displayError("FAILED UPDATING EVENT");
            }
            start();


        }
        else if(actionID==3){
            //remove event
            eventView.showRemoveEventMenu();
            int eventID = eventView.getInt("Event ID");
            if(removeEvent(eventID))
                eventView.displayMessage("SUCCESS REMOVING AN EVENT");
            else
                eventView.displayError("FAILED REMOVING AN EVENT");
            start();

        }
        else if(actionID==4){
            //send event reminder
            eventView.showSendReminderMenu();
            int eventID = eventView.getInt("Event ID");
            ReminderType reminderType= eventView.getReminderType();
            int attendantID = eventView.getInt("Attendant ID");
            if(sendEventReminder(eventID,reminderType,attendantID))
                eventView.displayMessage("SUCCESS SENDING A REMINDER");
            else
                eventView.displayError("FAILED SENDING A REMINDER");


            start();


        }
        else if(actionID==5){
            //event attend
            eventView.showAttendEventMenu();
            int eventID = eventView.getInt("Event ID");
            int userID = eventView.getInt("User ID");
            if(eventAttend(eventID, userID)){
                eventView.displayMessage("SUCCESS ATTENDING AN EVENT");
            }
            else
                eventView.displayError("FAILED ATTENDING AN EVENT");
            start();

        }
       else if(actionID==6){
            printAllEvents();
            start();
        }
       else if(actionID==7){
           printAllUsers();
           start();
        }
        else if(actionID==8){
            //start event
            int eventID = eventView.getInt("Event ID");
            Event event= eventRepository.getEvent(eventID);
            if(event!=null){
                eventStart(event);
            }
            start();
        }
        else if(actionID==9){
            //cancel event
            int eventID = eventView.getInt("Event ID");
            Event event= eventRepository.getEvent(eventID);
            if(event!=null){
                eventCancel(event);
            }
            start();
        }
        else if(actionID==10){
            //close event
            int eventID = eventView.getInt("Event ID");
            Event event= eventRepository.getEvent(eventID);
            if(event!=null){
                eventCloseRegistration(event);
            }
            start();
        }
        else if(actionID==11){
            int eventID = eventView.getInt("Event ID");
            Event event= eventRepository.getEvent(eventID);
            if(event!=null){
                eventView.displayMessage(eventGetState(event));
            }
            start();
        }

        else if(actionID==12){
            //exit

        }
        else {
            eventView.displayError("ERROR NOT A VALID CHOICE, PLEASE TRY AGAIN");
            start();

        }
    }
    public boolean eventAttend(int eventID, int userID){
        Event event = eventRepository.getEvent(eventID);
        if(event==null){
            return false;
        }
        User user = userRepoisitory.getUser(userID);
        if(user==null){
            return false;
        }
        event.register((Attendant)user);
        return true;

    }
    public int createEvent(String eventName, String eventType, double cost, String eventDescription, int capacity, LocalDateTime dateTime){
        Event event;
        if(eventType.equals("Fundraisers")){
            event = eventFactory.createEvent(eventName,"FUNDRAISERS", "DRAFT", cost, eventDescription, capacity,  dateTime);
        }
        else if(eventType.equals("Outreach")){
            event = eventFactory.createEvent(eventName,"OUTREACH", "DRAFT", cost, eventDescription,  capacity, dateTime);
        }
        else if(eventType.equals("Workshop")){
            event = eventFactory.createEvent(eventName,"WORKSHOP", "DRAFT", cost, eventDescription,  capacity,  dateTime);
        }
        else {
            eventView.displayError("ERROR NOT A VALID CHOICE, PLEASE TRY AGAIN");
            return -1;
        }
        if(event==null){
            return -1;
        }
        eventRepository.addEvent(event);
        return event.getEventID();
    }
    public boolean updateEvent(String description, int eventID){
        Event event = eventRepository.getEvent(eventID);
        if(event!=null){
            event.setEventDescription(description);
            return true;
        }
        else return false;
    }
    public boolean removeEvent(int eventID){
        return eventRepository.removeEvent(eventID);
    }
    public boolean sendEventReminder(int eventID, ReminderType reminderType, int attendID){
        Event event = eventRepository.getEvent(eventID);
        if(event==null){
            return false;
        }
        User attendant = userRepoisitory.getUser(attendID);
        if(attendant==null){
            return false;
        }
        List<Attendant> attendantList = event.getAttendantList();
        //just make sure the attendant is on the event attend list
        boolean result = false;
        for(Attendant a: attendantList){
            if(a.getId()==attendant.getId()){
                result = true;
                break;
            }
        }

        if(!result){
            return false;
        }

        if(reminderType==ReminderType.EMAIL){
            event.setReminderStrategy(new EmailStrategy());
        }
        else if(reminderType==ReminderType.WHATSAPP){
            event.setReminderStrategy(new WhatsAppStrategy());
        }
        else if(reminderType==ReminderType.SMS){
            event.setReminderStrategy(new SMSStrategy());
        }
        else return false;

        event.sendReminder((Attendant) attendant);
        return true;

    }
    public void printAllEvents() {
        eventView.printAllEvents(eventRepository.getAllEvents());
    }
    public void printAllUsers() {
        eventView.printAllUsers(userRepoisitory.getAllUsers());
    }
    public void eventStart(Event event){
        event.startEvent();
    }
    public void eventCancel(Event event){
        event.cancel();
    }
    public void eventCloseRegistration(Event event){
        event.closeRegistration();
    }
    public String eventGetState(Event event){
        return event.getEventState();
    }
}
