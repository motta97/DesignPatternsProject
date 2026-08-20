package EventMVC;

import utility.User;

import java.util.List;

public class UserRepository {
    private UserFileManager userFileManager;
    private List<User> users;
    public UserRepository() {
        userFileManager = UserFileManager.getInstance();
        load();
    }
    public void save(){
        userFileManager.save(users);
    }
    public void load(){
        this.users=userFileManager.load();
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
        load();
        for(User user:users){
            if(user.getId()==userID){
                return user;
            }
        }
        return null;
    }

}
