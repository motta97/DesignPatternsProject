package CommunicationMVC;

import Enums.ReminderType;
import Enums.SocialMediaType;

import java.util.Scanner;

public class CommunicationView {

    private Scanner scanner;

    public CommunicationView() {
        scanner = new Scanner(System.in);
    }


    public void showCommunicationMainMenu() {

        System.out.println("");

        System.out.println("----Communication Management----");
        System.out.println("");
        System.out.println("1. Send Message");
        System.out.println("2. Post on Social Media");
        System.out.println("3. Register to an Event");
        System.out.println("4. Send Campaign");
        System.out.println("5. Exit");
        System.out.print("choicee: ");
    }

    public void showSendMessageMenu() {

        System.out.println("\n---- Send Message ----");
        System.out.print("Enter User ID: ");
    }

    public void showPostOnSocialMediaMenu() {

        System.out.println("---- Post On Social Media ----");
        System.out.println("Choose Platform:");
        System.out.println("1. Facebook");
        System.out.println("2. X (Twitter)");
        System.out.println("3. Instagram");
    }

    public void showRegisterToAnEventMenu() {

        System.out.println("\n===== Register To Event =====");
        System.out.print("Enter Event ID: ");
    }

    public void showSendToCampaignMenu() {

        System.out.println("\n========== Send Campaign ==========");
        System.out.print("Enter number of users: ");
    }
//input methods

    public int getInt() {

        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();//removes the invalid input
        }

        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

    public String getString() {

        return scanner.nextLine();
    }

    public ReminderType getReminderType() {

        System.out.println("Reminder Type");
        System.out.println("1. EMAIL");
        System.out.println("2. SMS");

        int choice = getInt();

        switch (choice) {
            case 1:
                return ReminderType.EMAIL;

            case 2:
                return ReminderType.SMS;

            default:
                System.out.println("Invalid choice. making default as EMAIL");
                return ReminderType.EMAIL;
        }
    }

    public SocialMediaType getSocialMediaType() {

        int choice = getInt();

        switch (choice) {

            case 1:
                return SocialMediaType.FACEBOOK;

            case 2:
                return SocialMediaType.X;

            case 3:
                return SocialMediaType.INSTAGRAM;

            default:
                System.out.println("Invalid choice. making default as FACEBOOK.");
                return SocialMediaType.FACEBOOK;
        }
    }


    public void displayMessage(String message) {

        System.out.println(message);
    }

    public void displayError(String error) {

        System.out.println("ERROR! " + error);
    }
}
