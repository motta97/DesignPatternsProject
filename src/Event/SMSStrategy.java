package Event;
public class SMSStrategy implements ReminderStrategy{
    private final int sms_char_limit = 200;
    public String formatMessage(Event event, Attendant attendant){

        String fullMessage = String.format("Hi %s, reminder of the event %s",
                attendant.getName(), event.getEventName());
        return truncateOrSplit(fullMessage);
    }
    public String truncateOrSplit(String message){
        if(message.length() < sms_char_limit){
            return message;
        }
        return message.substring(0, sms_char_limit);
    }
    public void deliver(String formattedMessage, Attendant attendant){
        SMSGateway.send(attendant.getName(), formattedMessage);
    }
}