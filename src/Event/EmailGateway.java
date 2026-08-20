package Event;

public class EmailGateway {
    public static void send(String message, Attendant attendant) {
        //can be replaced by real API
        System.out.println("Delivering "+ message +" to: "+ attendant.getPhone()+ " VIA EMAIL");
    }
}
