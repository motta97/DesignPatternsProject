package EventMVC;

import BeneficaryManagement.User;

import java.util.List;

public class UserFileManager {
    private static UserFileManager uniqueInstance = null;
    public static UserFileManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UserFileManager();
        }
        return uniqueInstance;
    }
    private UserFileManager() {}
    public List<User> load{

    }
}
