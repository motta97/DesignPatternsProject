package Event;
public class WhatsAppStrategy implements ReminderStrategy {

    @Override
    public String formatMessage(Event event, Attendant attendant) {
        String template = "Hi *%s*! \nReminder: _%s_ is coming up ";
        String raw = String.format(template,
                attendant.getName(), event.getEventName());

        return applyWhatsAppFormatting(raw, event);
    }
    private String applyWhatsAppFormatting(String base, Event event) {
        StringBuilder sb = new StringBuilder(base);
        if (event.getEventType().equals("FUNDRAISERS")) {
            sb.append("\n every contribution helps!");
        } else if (event.getEventType().equals("WORKSHOP")) {
            sb.append("\n bring a notebook — hands-on session");
        }
        return sb.toString();
    }

    @Override
    public void deliver(String message, Attendant attendant) {
        WhatsAppGateway.send(attendant.getPhone(), message);
    }
}