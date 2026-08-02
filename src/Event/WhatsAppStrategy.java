package Event;
public class WhatsAppStrategy implements ReminderStrategy{
    public void sendReminder(Attendant attendant){
        System.out.println("Sending Reminder via WhatsApp to :" +attendant.getName());
    }
}