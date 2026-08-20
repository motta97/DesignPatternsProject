package Commuincation;

public class InstagramAPI extends APITemplate{
    public void connectToCommunicationService(){
        System.out.println("CONNECTING TO INSTAGRAM SERVICE...");
    }
    public void sendMessage(String message){
        System.out.println("POSTING "+message+ " via INSTAGRAM... ");
    }
}
