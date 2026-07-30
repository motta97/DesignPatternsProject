package EventMVC;

import BeneficaryManagement.User;
import Commuincation.CommunicationFacade;

import java.util.List;

public class UserRepoisitory {
    private UserFileManager userFileManager;
    private List<User> users;
    public UserRepoisitory() {
        userFileManager = UserFileManager.getInstance();
    }
    public void save(){
        userFileManager.save(users);
    }
    public void load(){
        users=userFileManager.load();
    }
    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }
    public List<User> getAllUsers(){
        return users;
    }
    public User getUser(int userID){
        for(User user:users){
            if(user.getId()==userID){
                return user;
            }
        }
        return null;
    }

}
