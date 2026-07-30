package Commuincation;

import BeneficaryManagement.User;

public class WhatsAppStrategy implements CommunicationStrategy
{
    public void send(User receiver, String message){
        System.out.println("SENDING "+message+ "to "+ receiver.getName()+ " VIA WHATSAPP");
    }

}
