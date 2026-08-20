package utility;

import EventMVC.UserRepository;

public class UserController {
    UserRepository userRepoisitory;
    UserView userView;
    public UserController() {
        userRepoisitory = new UserRepository();
        userView = new UserView();
    }
    public boolean mainMenu() {
        userView.showMainMenu();
        int choice = userView.getInt("Choice");
        return process(choice);
    }
    public boolean process(int choice) {
        switch (choice) {
            case 1:{
                //login
                userView.showLoginMenu();
                int userId = userView.getInt("User ID");
                User user = userRepoisitory.getUser(userId);
                if(user == null){
                    userView.displayError("User doesn't exist");
                    return false;

                }
                else {
                    userView.displayMessage("Successfully logged in");
                    return true;
                }

            }
            case 2:{
                //sign up
                userView.showSignUpMenu();
                String userName = userView.getString("User Name");
                String userEmail = userView.getString("User Email");
                String userPhone = userView.getString("User Phone");
                String userType = userView.getUserType();

                UserFactory.createUser(userType,userName,userEmail,userPhone );
                userView.displayMessage("Successfully signed up");
                return true;
            }
            default:{
                userView.displayError("Invalid choice");
                return false;
            }



        }
    }
}
