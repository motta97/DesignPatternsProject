package Commuincation;


import CommunicationMVC.CommunicationController;
import utility.User;
import Enums.ReminderType;
import Enums.SocialMediaType;
import Event.Event;
import Event.EventObserver;

import java.util.List;

public class CommuincationService implements EventObserver {
    private Event event;
    private CommunicationProxy communicationFacadeProxy = new CommunicationProxy();
    private  SocialMediaFacade socialMediaFacade = new SocialMediaFacade();
    private User currentUser;
    public CommuincationService(Event event){
        this.event = event;
        event.registerObserver(this);

    }
    public CommuincationService(User currentUser){
        this.currentUser = currentUser;
        this.event = null;
    }

    public void setEvent(Event event) {
        this.event = event;
        event.registerObserver(this);
    }

    public boolean sendMessage(User reciever, String message, ReminderType reminderType) {
        if(reminderType == ReminderType.SMS){
            communicationFacadeProxy.setCommunicationStrategy(new SMSStrategy());
        }
        else if(reminderType == ReminderType.EMAIL ){
            communicationFacadeProxy.setCommunicationStrategy(new EmailStrategy());
        }
        else if(reminderType == ReminderType.WHATSAPP){
            communicationFacadeProxy.setCommunicationStrategy(new WhatsAppStrategy());
        }
        return communicationFacadeProxy.sendMessage(currentUser, reciever, message);

    }
    @Override
    public void updateEventObserver(String eventNotification){
        sendCampaign(CommunicationController.getUsers(), eventNotification);
    }

    public boolean sendCampaign(List<User> receivers, String message){
        return communicationFacadeProxy.sendCampaign(currentUser, receivers,message);
    }
    public boolean postOnSocialMedia(String description, SocialMediaType socialMediaType){
        if(socialMediaType.equals(SocialMediaType.FACEBOOK))
            socialMediaFacade.setSocialMediaStrategy(new FacebookStrategy(new FacebookAPI()));
        else if(socialMediaType.equals(SocialMediaType.INSTAGRAM))
            socialMediaFacade.setSocialMediaStrategy(new InstagramStrategy(new InstagramAPI()));
        else if(socialMediaType.equals(SocialMediaType.X))
            socialMediaFacade.setSocialMediaStrategy(new XStrategy(new XAPI()));

       return socialMediaFacade.post(description);
    }
    public void postOnAll(String description){
        socialMediaFacade.postOnAll(description);
    }
}
