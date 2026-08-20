package EventMVC;

import utility.User;
import utility.UserFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileManager {
    private List<User> users;
    private static UserFileManager uniqueInstance = null;

    public static UserFileManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UserFileManager();
        }
        return uniqueInstance;
    }

    private UserFileManager() {}
    public List<User> load() {

        List<User> users = new ArrayList<>();

        File file = new File("users.txt");

        if (!file.exists()) {
            return users;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {

                lineNumber++;

                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                //we store the name, type, email, and phoneNumber
                if (parts.length != 4) {
                    System.err.println(
                            "skip corrupted line " + lineNumber + ": " + line);
                    continue;
                }

                try {

                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    String email = parts[2].trim();
                    String phoneNumber = parts[3].trim();
                    User user = UserFactory.createUser(type, name, email, phoneNumber);

                    if (user != null) {
                        users.add(user);
                    }
                    else {
                        System.err.println(
                                "unknown user type at line "
                                        +lineNumber + ": " + type);
                    }

                }

                catch (Exception e) {
                    System.err.println("Error reading line "+ lineNumber + ": " + e.getMessage());}
            }

        }
        catch (IOException e) {
            System.err.println("faild to load users: " + e.getMessage());}

        return users;
    }
    public void save(List<User> users) {
        try (PrintWriter writer =
                     new PrintWriter(new FileWriter("users.txt", true))) {//true to make it append

            for (User user : users) {
                writer.println(
<<<<<<< Updated upstream
                        user.getId() + "," + user.getName().replace(",","") + "," + user.getType().replace(",","")
=======
                        user.getName().replace(",","") + "," + user.getType().replace(",","")
                        +"," + user.getEmail().replace(",","") + "," + user.getPhone().replace(",","")
>>>>>>> Stashed changes
                );
            }

        }
        catch(IOException e){
            System.out.println("Error saving users.txt");
        }

    }
}
