package Commuincation;

import utility.User;

import java.util.List;

public class CommunicationFacade implements Subject{
    CommunicationStrategy communicationStrategy;
    public void setCommunicationStrategy(CommunicationStrategy communicationStrategy) {
        this.communicationStrategy = communicationStrategy;
    }

    public boolean sendMessage(User sender, User receiver, String message) {

            if(communicationStrategy==null){
                System.out.println("communicationStrategy is null");
                return false;
            }
        return communicationStrategy.send(receiver, message);

    }
    public boolean sendCampaign(User sender, List<User> receivers, String message){
        boolean result = true;
        this.communicationStrategy= new SMSStrategy();
        for(User user : receivers){
            if(!sendMessage(sender, user,message))
                result = false;
        }
        return result;
    }
}
