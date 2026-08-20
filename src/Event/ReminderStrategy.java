
package Event;

public interface ReminderStrategy{
<<<<<<< Updated upstream
    void sendReminder(Attendant attendant);
=======
    default void sendReminder(Event event, Attendant attendant){
        String formattedMessage = formatMessage(event,attendant);
        deliver(formattedMessage, attendant);
    }
    String formatMessage(Event event, Attendant attendant);
    void deliver(String formattedMessage, Attendant attendant);

>>>>>>> Stashed changes
}