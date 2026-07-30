package Commuincation;


import BeneficaryManagement.User;
import Enums.ReminderType;
import Enums.SocialMediaType;
import Event.Event;
import Event.EventObserver;
import EventMVC.UserFileManager;

import java.util.List;

public class CommuincationService implements EventObserver {
    private Event event;
    private CommunicationFacade communicationFacade;
    private  SocialMediaFacade socialMediaFacade;

    private List<User> users;
    private UserFileManager userFileManager;
    public CommuincationService(){
        event

    }
    public boolean sendMessage(User reciever, String message, ReminderType reminderType) {
        if(reminderType == ReminderType.SMS){
            communicationFacade.setCommunicationStrategy(new SMSStrategy());
        }
        else if(reminderType == ReminderType.EMAIL ){
            communicationFacade.setCommunicationStrategy(new EmailStrategy());
        }
        else if(reminderType == reminderType.WHATSAPP){
            communicationFacade.setCommunicationStrategy(new WhatsAppStrategy());
        }
        return communicationFacade.sendMessage(reciever, message);

    }
    @Override
    public void updateEventObserver(String eventNotification){
        this.users=userFileManager.load();
        communicationFacade.sendCampaign(users,eventNotification);
    }
    public void postOnSocialMedia(String description, SocialMediaType socialMediaType){
        if(socialMediaType.equals(SocialMediaType.FACEBOOK))
            socialMediaFacade.setSocialMediaStrategy(new FacebookStrategy());
        else if(socialMediaType.equals(SocialMediaType.INSTAGRAM))
            socialMediaFacade.setSocialMediaStrategy(new InstagramStrategy());
        else if(socialMediaType.equals(SocialMediaType.X))
            socialMediaFacade.setSocialMediaStrategy(new XStrategy());

        socialMediaFacade.post(description);
    }
    public void postOnAll(String description){
        socialMediaFacade.postOnAll(description);
    }
}
