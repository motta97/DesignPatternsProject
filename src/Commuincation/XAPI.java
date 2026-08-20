package Commuincation;

public class XAPI extends APITemplate{
    public void connectToCommunicationService(){
        System.out.println("Connecting to X Communication Service");
    }
    public void sendMessage(String message){
        System.out.println("POSTING "+message+ " via X ");
    }
}
