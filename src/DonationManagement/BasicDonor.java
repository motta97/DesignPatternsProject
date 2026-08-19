package DonationManagement;
import utility.txtGetter;

import java.util.ArrayList;

public class BasicDonor extends Donor {
    private ArrayList<Donation> donations;

    public BasicDonor(String name ,  String phone , String email){
        super(name  ,phone ,email);
        this.donations =new ArrayList<>() ;
    }

    @Override
    public String getType() {
        return "BasicDonor";
    }

    public void addDonation(Donation ref) {
        donations.add(ref) ;

    }

    public void showDonations() {

        if(donations.size() > 0){
      for(int i =0 ;i <donations.size() ; i++)
      {
          System.out.println(donations.get(i).toString());
      }
        }
    }




    @Override
    public String getDescription() {
        return txtGetter.getMessage("BasicDonor_getDescription","src/DonationManagement/DonationManagementMessages.txt");
    }

    @Override
    public String showBenefits() {
        return txtGetter.getMessage("BasicDonor_showBenefits","src/DonationManagement/DonationManagementMessages.txt");
    }
}
