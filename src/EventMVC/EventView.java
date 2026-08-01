package EventMVC;

import Enums.ReminderType;
import Event.Event;

import java.util.Scanner;

public class EventView {

    private Scanner scanner;
    private EventRepository eventRepository;
    public EventView() {
        scanner = new Scanner(System.in);
        eventRepository = new EventRepository();
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
        System.out.println("6. Exit");
        System.out.print("Choice: ");
    }

    public void showCreateEventMenu() {

        System.out.println("---- Create Event ----");
        System.out.print("Enter Event Name: ");
    }

    public void showUpdateEventMenu() {

        System.out.println("---- Update event ----");
        System.out.print("Enter Event ID: ");
    }

    public void showRemoveEventMenu() {

        System.out.println("---- Remove Event ----");
        System.out.print("Enter Event ID: ");
    }

    public void showSendReminderMenu() {

        System.out.println("---- Send Event Reminder ----");
    }

    public void showAttendEventMenu() {

        System.out.println("---- Attend Event ----");
    }
//input methods

    public int getInt() {

        while (!scanner.hasNextInt()) {

            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        int value = scanner.nextInt();

        scanner.nextLine();


        return value;
    }

    public String getString() {

        return scanner.nextLine();
    }

    public ReminderType getReminderType() {

        System.out.println("\nChoose Reminder Type");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. WhatsApp");
        System.out.print("Choice: ");

        int choice = getInt();

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

}