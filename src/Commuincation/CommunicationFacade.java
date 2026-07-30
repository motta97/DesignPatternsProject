package Commuincation;

import BeneficaryManagement.User;

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
    public void sendCampaign(List<User> users, String message){
        for(User user : users){
            sendMessage(user,message);
        }
    }
}
