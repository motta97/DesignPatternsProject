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

                // Ignore empty lines
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length != 5) {
                    System.err.println(
                            "Skipping malformed line " + lineNumber +
                                    ": " + line);
                    continue;
                }

                try {

                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String type = parts[2].trim();
                    String email = parts[3].trim();
                    String phoneNumber = parts[4].trim();
                    User user = UserFactory.createUser(type, name, email, phoneNumber);

                    if (user != null) {
                        users.add(user);
                    }
                    else {
                        System.err.println(
                                "Unknown user type at line "
                                        +lineNumber + ": " + type);
                    }

                }
                catch (NumberFormatException e) {

                    System.err.println(
                            "Invalid ID at line "
                                    + lineNumber + ": " + line);

                }
                catch (Exception e) {

                    System.err.println(
                            "Error reading line "
                                    + lineNumber + ": "
                                    + e.getMessage());

                }

            }

        }
        catch (IOException e) {

            System.err.println(
                    "Failed to load users: "
                            + e.getMessage());

        }

        return users;
    }
    public void save(List<User> users) {
        try (PrintWriter writer =
                     new PrintWriter(new FileWriter("users.txt"))) {

            for (User user : users) {
                writer.println(
                        user.getId() + "," + user.getName() + "," + user.getType()
                );
            }

        }
        catch(IOException e){
            System.out.println("Error saving users.txt");
        }

    }
}
