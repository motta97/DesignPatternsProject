package Commuincation;

import Enums.UserType;
import utility.User;

import java.util.List;
//this proxy provides access control
public class CommunicationProxy implements Subject{
    private CommunicationFacade facade;
    public void setCommunicationStrategy(CommunicationStrategy communicationStrategy){
        facade.setCommunicationStrategy(communicationStrategy);
    }
    public boolean sendMessage(User sender, User receiver, String message){
        if( sender ==null || sender.getType() == UserType.BASIC_ATTENDANT){
            //basic attendant can't send messages
            return false;
        }
       return facade.sendMessage(sender,receiver, message);
    }
    public boolean sendCampaign(User sender, List<User> receivers, String message){
        return facade.sendCampaign(sender, receivers, message);
    }
}
