package EventMVC;

import BeneficaryManagement.User;
import Enums.ReminderType;
import Event.Event;
import Event.Attendant;
import Event.WhatsAppStrategy;
import Event.SMSStrategy;
import Event.EmailStrategy;
import java.util.List;

public class EventContoller {
    private EventRepository eventRepository;
    private UserRepoisitory userRepoisitory;
    private EventView eventView;

    public EventContoller(){
        eventRepository = new EventRepository();
        userRepoisitory = new UserRepoisitory();
        eventView = new EventView();


    }
    public void mainMenu(){

        eventView.showEventMainMenu();
        int choice = eventView.getInt();
        process(choise);
    }
    public void process(int actionID){
        if(actionID==1){
            eventView.showCreateEventMenu();
            String eventName= eventView.getString();
            int eventID= createEvent(eventName);
            eventView.showEventDetails(eventID);
            return;
        }
        if(actionID==2){
            //update an event
            eventView.showUpdateEventMenu();
            int eventID= eventView.getInt();
            String eventDescription = eventView.getString();
            boolean result =updateEvent(eventDescription, eventID);
            if(result){
                eventView.displayMessage("SUCCESS UPDATING EVENT");
            }
            else {
                eventView.displayError("FAILED UPDATING EVENT");
            }
            return;

        }
        if(actionID==3){
            //remove event
            eventView.showRemoveEventMenu();
            int eventID = eventView.getInt();
            if(removeEvent(eventID))
                eventView.displayMessage("SUCCESS REMOVING AN EVENT");
            else
                eventView.displayError("FAILED REMOVING AN EVENT");
            return;
        }
        if(actionID==4){
            //send event reminder
            eventView.showSendReminderMenu();
            eventView.displayMessage("Please enter the Event ID: ");
            int eventID = eventView.getInt();
            ReminderType reminderType= eventView.getReminderType();
            eventView.displayMessage("Please enter Attendant ID: ");
            int attendantID = eventView.getInt();
            if(sendEventReminder(eventID,reminderType,attendantID))
                eventView.displayMessage("SUCCESS SENDING A REMINDER");
            else
                eventView.displayError("FAILED SENDING A REMINDER");


            return;

        }
    }
    public int createEvent(String eventName){
        Event event = new Event(eventName);
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
        boolean result = false;
        for(Attendant a: attendantList){
            if(a.getId()==attendant.getId()){
                result = true;
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

    }
}
