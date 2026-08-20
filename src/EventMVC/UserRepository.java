package EventMVC;

import utility.User;

import java.util.List;

public class UserRepository {
    private static UserFileManager userFileManager;
    private static List<User> users;
    private static UserRepository instance;
    private UserRepository() {

    }
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
            userFileManager = UserFileManager.getInstance();
            load();
        }
        return instance;
    }
    public void save(){
        userFileManager.save(users);
    }
    public static void load(){
        users=userFileManager.load();
    }
    public void addUser(User user){
        load();
        users.add(user);
        save();
    }
    public void removeUser(User user){
        load();
        users.remove(user);
        userFileManager.saveNew(users);
    }
    public List<User> getAllUsers(){
        load();
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
