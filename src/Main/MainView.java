package Main;

<<<<<<< Updated upstream
public class MainView {
    public void showMenu(){
=======
import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);
    public void showMainMenu(){
>>>>>>> Stashed changes
        System.out.println("""
                ===== Main Module =====
                1.Donation Module
                2.Beneficiary Module
<<<<<<< Updated upstream
                0.return back
                """);
    }
=======
                3. Event Module
                4. Communication Module
                
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
>>>>>>> Stashed changes
}
