package EventMVC;

import Enums.ReminderType;
import Event.Event;
import Event.EventIterator;
import Event.UserIterator;
import utility.User;

import java.util.List;
import java.util.Scanner;

public class EventView {

    private Scanner scanner;
    private EventRepository eventRepository;
    private UserRepository userRepository;
    public EventView() {
        scanner = new Scanner(System.in);
        eventRepository = new EventRepository();
        userRepository = new UserRepository();
    }

//menus
    public void showEventMainMenu() {

        System.out.println("----------------------------------------");
        System.out.println("        Event Management");
        System.out.println("----------------------------------------");
        System.out.println("1. Create Event");
        System.out.println("2. Update Event");
        System.out.println("3. Remove Event");
        System.out.println("4. Send Event Reminder");
        System.out.println("5. Attend Event");
        System.out.println("6. View Events");
        System.out.println("7. View Users");
        System.out.println("8. Start an Event");
        System.out.println("9. Cancel an Event");
        System.out.println("10. Close Registration for an event");
        System.out.println("11. Get the state of an event");
        System.out.println("12. Exit");
    }

    public void showCreateEventMenu() {

        System.out.println("---- Create Event ----");

    }

    public void showUpdateEventMenu() {

        System.out.println("---- Update event ----");
    }

    public void showRemoveEventMenu() {

        System.out.println("---- Remove Event ----");
    }

    public void showSendReminderMenu() {

        System.out.println("---- Send Event Reminder ----");
    }

    public void showAttendEventMenu() {

        System.out.println("---- Attend Event ----");
    }
//input methods

    public int getInt(String message) {
        System.out.println("Please enter " + message);
        while (!scanner.hasNextInt()) {

            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        int value = scanner.nextInt();

        scanner.nextLine();


        return value;
    }
    public double getDouble(String message) {
        System.out.println("Please enter " + message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public String getString(String printing)
    {
        System.out.println("Please enter "+printing+": ");
        return scanner.nextLine();
    }

    public ReminderType getReminderType() {

        System.out.println("\nChoose Reminder Type");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. WhatsApp");

        int choice = getInt("Choice");

        switch (choice) {

            case 1:
                return ReminderType.EMAIL;

            case 2:
                return ReminderType.SMS;

            case 3:
                return ReminderType.WHATSAPP;

            default:
                System.out.println("Invalid choice. choosing default as EMAIL.");
                return ReminderType.EMAIL;
        }
    }

//output methods

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.out.println("ERROR " + error);
    }

    public void showEventDetails(int eventID) {

        System.out.println("--------------------------------------------");
        System.out.println("Event Created Successfully!");
        System.out.println("Event ID: " + eventID);
        Event event =eventRepository.getEvent(eventID);
        System.out.println("Event Name: " + event.getEventName());
        System.out.println("--------------------------------------------");
    }
    public void printAllEvents(List<Event> events){
        EventIterator eventIterator = new EventIterator(events);
        while (eventIterator.hasNext()) {
            Event event = eventIterator.next();
            System.out.println("Event Name: " + event.getEventName());
            System.out.println("Event ID: " + event.getEventID());
            System.out.println("Event Type: " + event.getEventType());
            System.out.println("Event Description: " + event.getDescription());
            System.out.println("Event Cost "+ event.getEventID());
            System.out.println("---------------------------------");
        }
    }
    public void printAllUsers(List<User> users){
        UserIterator userIterator = new UserIterator(users);
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            System.out.println("User Name: "+ user.getName());
            System.out.println("User ID: "+ user.getId());
            System.out.println("User Type: "+ user.getType());
            System.out.println("User Email: "+ user.getEmail());
            System.out.println("User Phone"+ user.getPhone());
            System.out.println("---------------------------------");
        }
    }

}