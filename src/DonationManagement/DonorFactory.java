package DonationManagement;

import java.util.Locale;

public class DonorFactory {

    public static Donor createDonor(String name,  String type, String phone, String email) {

      Donor donor = new BasicDonor(name,  phone, email) ;

         switch (type.trim().toLowerCase()) {


            case "premium" ->{
                donor=  new PremiumDonor(donor);}


            case "vip" ->
                    donor= new VIPDonor(new PremiumDonor(donor));



        };
    return donor;
    }
}
