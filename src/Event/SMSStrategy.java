package Event;
public class SMSStrategy implements ReminderStrategy{
    public void sendReminder(Attendant attendant){
        System.out.println("Sending Reminder via SMS to :" +attendant.getName());
    }
}