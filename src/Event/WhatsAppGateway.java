package Event;

public class WhatsAppGateway {
    public static void send(String phone, String message) {
        //can be replaced by real API
        System.out.println("Sending "+ message +" to: "+ phone + " VIA WHATSAPP");
    }
}
