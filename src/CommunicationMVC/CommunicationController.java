package CommunicationMVC;

import BeneficaryManagement.User;
import Commuincation.CommuincationService;
import Enums.ReminderType;
import Enums.SocialMediaType;
import EventMVC.UserRepoisitory;

public class CommunicationController {
    private CommunicationView view;
    private CommuincationService commuincationService;
    private UserRepoisitory userRepoisitory;
    public CommunicationController(){
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

                break;

                case 2:
                    //post on social media
                    view.showPostOnSocialMediaMenu();
                    SocialMediaType socialMediaType = view.getSocialMediaType();
                    String description = view.getString();


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
