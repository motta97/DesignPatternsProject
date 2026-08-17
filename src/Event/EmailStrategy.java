package Event;
public class EmailStrategy implements ReminderStrategy{
    public void sendReminder(Attendant attendant){
        System.out.println("Sending Reminder via Email to :" +attendant.getName());
    }
}