package utility;

import BeneficaryManagement.BeneficaryFactory;
import DonationManagement.BasicDonor;
import DonationManagement.Donor;
import DonationManagement.DonorFactory;
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
            user = DonorFactory.createDonor(name,"basic",phoneNumber,email) ;
        }

        else if(userType.equals("PREMIUM_DONOR")){
            user = DonorFactory.createDonor(name,"premium",phoneNumber,email) ;
        }
        else if(userType.equals("VIP_DONOR")){
            user = DonorFactory.createDonor(name,"vip",phoneNumber,email) ;
        }
        else if(userType.equals("ADMIN_VOULANTEER")){
            //create admin voulanteer
        }
        else if(userType.equals("PHYSICAL_VOULANTEER")){
            //create physical voulanteer
        }
        else if(userType.equals("BASIC_BENEFECIARY")){
            user = BeneficaryFactory.createBeneficary(name,phoneNumber,email,"collection");
        }

        else user = null;
        return user;




    }
}
