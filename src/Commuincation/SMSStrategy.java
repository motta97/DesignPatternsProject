package Commuincation;

import utility.User;

public class SMSStrategy implements CommunicationStrategy
{
    public boolean send(User receiver, String message){
        System.out.println("SENDING "+message+ "to "+ receiver.getName()+ " VIA SMS");
        return true;
    }

}
