package utility;

import Enums.ReminderType;

import java.util.Scanner;

public class UserView {
    private Scanner scanner;
    public UserView() {
        scanner = new Scanner(System.in);
    }
    public void showMainMenu(){

    }
    public void showSignUpMenu(){

    }
    public void showLoginMenu(){

    }
    public String getString(String printing)
    {
        System.out.println("Please enter "+printing+": ");
        return scanner.nextLine();
    }

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
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.out.println("ERROR " + error);
    }
    public String getUserType() {

        System.out.println("\nChoose Reminder Type");
        System.out.println("1. Donor");
        System.out.println("2. Attendant");
        System.out.println("3. Voulanteer");

        int choice = getInt("Choice");

        switch (choice) {

            case 1:
                return "DONOR";

            case 2:
                return "ATTENDANT";

            case 3:
                return "VOULANTEER";

            default:
                System.out.println("invalid choice. choosing default as ATTENDANT.");
                return "ATTENDANT";
        }
    }
}
