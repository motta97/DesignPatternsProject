package EventMVC;

import Event.Event;
import utility.User;
import utility.UserFactory;

import java.io.*;
<<<<<<< Updated upstream
=======
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.List;
import Event.EventFactory;

public class EventFileManager {
    private List<Event> events;
    private static EventFileManager uniqueInstance;
    private EventFileManager() {}
    public static EventFileManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EventFileManager();
        }
        return uniqueInstance;
    }
    public List<Event> load(){
        List<Event> events = new ArrayList<>();

        File file = new File("events.txt");

        if (!file.exists()) {
            return events;
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
                    //we store teh event name, cost, type, state, and description
<<<<<<< Updated upstream
                if (parts.length != 5) {
=======
                if (parts.length != 7) {
>>>>>>> Stashed changes
                    System.err.println(
                            "skip corrupted line " + lineNumber + ": " + line);
                    continue;
                }

                try {


                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    String state = parts[2].trim();
                    double cost = Double.parseDouble(parts[3].trim());
                    String description = parts[4].trim();
                    int capacity = Integer.parseInt(parts[5].trim());
<<<<<<< Updated upstream
                    Event event = EventFactory.createEvent(name, type, state, cost, description,  capacity);
=======
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate date = LocalDate.parse(parts[6], fmt);
                    LocalDateTime dateTime = date.atStartOfDay();
                    Event event = EventFactory.createEvent(name, type, state, cost, description,  capacity, dateTime);
>>>>>>> Stashed changes

                    if (event != null) {
                        events.add(event);
                    }
                    else {
                        System.err.println(
                                "undefined event  at line "+lineNumber + ": " + type);
                    }

                }
                catch (Exception e) {
                    System.err.println("error reading line " + lineNumber + ": " + e.getMessage());
                }
            }

        }
        catch (IOException e) {
            System.err.println("failed to load events: "+ e.getMessage());
        }

        return events;
    }
    public  void save(List<Event> events){
        this.events = events;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
        //save to a text file
        try (PrintWriter writer =
                     new PrintWriter(new FileWriter("events.txt", true))) {//true to make it append

            for (Event event : events) {
<<<<<<< Updated upstream
                writer.println(
                        event.getEventName().replace(",","") + "," + event.getEventType().replace(",","")
                                + "," + event.getEventState().replace(",","") + ","+ event.getCost() + ","+ event.getDescription().replace(",", "")+","
                        + event.getCapacity()
=======

                writer.println(
                        event.getEventName().replace(",","") + "," + event.getEventType().replace(",","")
                                + "," + event.getEventState().replace(",","") + ","+ event.getCost() + ","+ event.getDescription().replace(",", "")+","
                        + event.getCapacity()+","+ event.getSchedule().format(DateTimeFormatter.ofPattern("d/M/yyyy"))
>>>>>>> Stashed changes
                );
            }

        }
        catch(IOException e){
            System.out.println("error saving events.txt");
        }

    }


}
