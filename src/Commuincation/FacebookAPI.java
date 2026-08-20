package Commuincation;

public class FacebookAPI extends APITemplate {
    public void connectToCommunicationService() {
        System.out.println("CONNECTING TO FACEBOOK SERVICE...");
    }
    public void sendMessage(String message) {

        System.out.println("POSTING "+message+ " via FACEBOOK...");
    }
}
