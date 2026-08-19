package utility;

import DonationManagement.BasicDonor;
import DonationManagement.Donor;
import DonationManagement.PremiumDonor;
import Enums.UserType;
import Event.Attendant;

public class UserFactory {
    private UserFactory() {}
    private static User user;
    public static User createUser(String userType, String name, String email, String phoneNumber) {
        if(userType.equals("BASIC_ATTENDANT")){
            user = new Attendant(name, email, phoneNumber);//!fix
        }
        else if(userType.equals("PREMIUM_ATTENDANT")){
            user = new Attendant(name, phoneNumber,email);
        }
        else if(userType.equals("BASIC_DONOR")){
            //create basic donor
        }

        else if(userType.equals("PREMIUM_DONOR")){
            //create premium donor
        }
        else if(userType.equals("ADMIN_VOULANTEER")){
            //create admin voulanteer
        }
        else if(userType.equals("PHYSICAL_VOULANTEER")){
            //create physical voulanteer
        }
        else if(userType.equals("BASIC_BENEFECIARY")){
            //create basic benef
        }
        else if(userType.equals("PREMIUM_BENEFECIARY")){
            //create premium benef
        }
        else user = null;
        return user;




    }
}
