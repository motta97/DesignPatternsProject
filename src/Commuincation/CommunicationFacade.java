package Commuincation;

import utility.User;

import java.util.List;

public class CommunicationFacade {
    CommunicationStrategy communicationStrategy;
    public void setCommunicationStrategy(CommunicationStrategy communicationStrategy) {
        this.communicationStrategy = communicationStrategy;
    }

    public boolean sendMessage(User receiver, String message) {

            if(communicationStrategy==null){
                return false;
            }
        return communicationStrategy.send(receiver, message);

    }
    public boolean sendCampaign(List<User> users, String message){
        boolean result = true;
        for(User user : users){
            if(!sendMessage(user,message))
                result = false;
        }
        return result;
    }
}
