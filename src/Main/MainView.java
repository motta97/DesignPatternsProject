package Main;

import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);
    public void showMainMenu(){
        System.out.println("""
                ===== Main Module =====
                1.Donation Module
                2.Beneficiary Module
                3.Event Module
                4.Communication Module
                
                0.return back
                """);
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
}
