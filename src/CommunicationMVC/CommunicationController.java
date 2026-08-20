package CommunicationMVC;

import EventMVC.EventRepository;
import utility.User;
import Commuincation.CommuincationService;
import Enums.ReminderType;
import Enums.SocialMediaType;
import Event.Event;
import EventMVC.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class CommunicationController {
    private final CommunicationView view;
    private final CommuincationService commuincationService;
    private static UserRepository userRepository;
    private static EventRepository eventRepository;
    private User currentUser;
    public CommunicationController(int currentUserID){
        userRepository = new UserRepository();
        eventRepository = new EventRepository();
        view = new CommunicationView();
        currentUser = userRepository.getUser(currentUserID);
        commuincationService = new CommuincationService(currentUser);
    }
    public void start(){
        view.showCommunicationMainMenu();
        int choiceID= view.getInt("Menu Choice");
        chooseAction(choiceID);
    }
    public void chooseAction(int choiceID){
        switch (choiceID){
            case 1:
                //send message
                view.showSendMessageMenu();
                int userID=view.getInt("UserID");
                String message = view.getString("Message");
                ReminderType reminderType = view.getReminderType();
               if(sendMessage(userID,message,reminderType))
                   view.displayMessage("SUCCESS SENDING A MESSAGE");
                else
                    view.displayError("FAIL SENDING A MESSAGE");
                start();
                break;

                case 2:
                    //post on social media
                    view.showPostOnSocialMediaMenu();
                    SocialMediaType socialMediaType = view.getSocialMediaType();
                    String description = view.getString("Description");
                    if(postOnSocialMedia(socialMediaType,description)){
                        view.displayMessage("SUCCESS SENDING A MESSAGE");
                    }
                    else{
                        view.displayError("FAIL SENDING A MESSAGE");
                    }
                    start();
                    break;

            case 3:
                //register to an event;
                view.showRegisterToAnEventMenu();
                int eventID  = view.getInt("EventID");
                if(registerToAnEvent(eventID)){
                    view.displayMessage("SUCCESS SENDING A MESSAGE");
                }
                else{
                    view.displayError("FAIL SENDING A MESSAGE");
                }
                start();
                break;
            case 4:
                //send campaign
                view.showSendToCampaignMenu();
                int numUsers =view.getInt("Number of users");//number of users
                List<User> users = new ArrayList<>();
                for(int i=0;i<numUsers;i++) {

                    int userIDCampaign = view.getInt("UserID");
                    User user = userRepository.getUser(userIDCampaign);
                    if (user == null) {
                        view.displayError("Failed to find a user with that ID");
                        break;
                    } else
                        users.add(user);
                }
                String messageCampagin = view.getString("Message");

                if(sendCampaign(users,messageCampagin)){
                    view.displayMessage("SUCCESS SENDING A CAMPAIGN");
                }
                else {
                    view.displayError("FAILED SENDING A CAMPAIGN");
                }
                start();

            break;
            case 5:
                //exit
                return;
            default:
                view.displayError("NOT A VALID CHOICE, PLEASE TRY AGAIN");
                start();
                break;

        }
    }
    public boolean sendMessage(int recipientID, String message, ReminderType reminderType){
        User recipient = userRepository.getUser(recipientID);
        if(recipient ==null){
            return false;
        }
        return commuincationService.sendMessage(recipient, message,reminderType);
    }

    public boolean postOnSocialMedia(SocialMediaType socialMediaType, String message){
        return commuincationService.postOnSocialMedia(message,socialMediaType);
    }
    public boolean sendCampaign(List<User> receivers, String message){
        if(currentUser==null){
            return false;
        }
        return commuincationService.sendCampaign(receivers,message);
    }
    public boolean registerToAnEvent(int EventID){
        Event event = eventRepository.getEvent(EventID);
        if(event!=null){
            commuincationService.setEvent(event);
            return true;
        }
        return false;
    }
    public static List<User> getUsers() {
        return userRepository.getAllUsers();
    }
}
