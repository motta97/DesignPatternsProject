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
    private CommunicationView view;
    private CommuincationService commuincationService;
    private UserRepository userRepoisitory;
    private EventRepository eventRepository;
    private Event event;
    public CommunicationController(){
        userRepoisitory = new UserRepository();
        eventRepository = new EventRepository();
        view = new CommunicationView();
        commuincationService = new CommuincationService();
        mainMenu();
    }
    public void mainMenu(){
        view.showCommunicationMainMenu();
        int choiceID= view.getInt();
        chooseAction(choiceID);
    }
    public void chooseAction(int choiceID){
        switch (choiceID){
            case 1:
                //send message
                view.showSendMessageMenu();
                int userID=view.getInt();
                String message = view.getString();
                ReminderType reminderType = view.getReminderType();
               if(sendMessage(userID,message,reminderType))
                   view.displayMessage("SUCCESS SENDING A MESSAGE");
                else
                    view.displayError("FAIL SENDING A MESSAGE");
                mainMenu();
                break;

                case 2:
                    //post on social media
                    view.showPostOnSocialMediaMenu();
                    SocialMediaType socialMediaType = view.getSocialMediaType();
                    String description = view.getString();
                    mainMenu();
                    break;

            case 3:
                //register to an event;
                view.showRegisterToAnEventMenu();
                int eventID  = view.getInt();
                Event event = eventRepository.getEvent(eventID);
                if(event!=null){
                    event.registerObserver(commuincationService);
                    view.displayMessage("SUCCESS REGISTERING TO EVENT!");
                }
                else {
                    view.displayError("FAILED REGISTERING TO EVENT");
                }
                mainMenu();
                break;
            case 4:
                //send campaign
                view.showSendToCampaignMenu();
                int numUsers =view.getInt();//number of users
                List<User> users = new ArrayList<>();
                for(int i=0;i<numUsers;i++){
                    view.displayMessage("Please enter user ID");
                    int userIDCampaign = view.getInt();
                    User user = userRepoisitory.getUser(userIDCampaign);
                    if(user==null){
                        view.displayError("Failed to find a user with that ID");
                        break;
                    }
                    else
                        users.add(user);
                }
                view.displayMessage("Plese enter the message");
                String messageCampagin = view.getString();

                commuincationService.sendCampaign(users,messageCampagin);
                mainMenu();

            break;
            case 5:
                //exit
                return;
            default:
                view.displayError("NOT A VALID CHOICE, PLEASE TRY AGAIN");
                mainMenu();

        }
    }
    public boolean sendMessage(int userID, String message, ReminderType reminderType){
        User user = userRepoisitory.getUser(userID);
        if(user==null){
            return false;
        }
        commuincationService.sendMessage(user, message,reminderType);
        return true;
    }
}
