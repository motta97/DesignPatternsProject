package DonationManagement;
import java.util.ArrayList;

public class BasicDonor extends Donor {
    private ArrayList<Donation> donations;

    public BasicDonor(String name , int id , String phone , String email){
        super(name ,id ,phone ,email);
        this.donations =new ArrayList<>() ;
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
        return "Name with Basic ";
    }

    @Override
    public String showBenefits() {
        return "some benefits for basic";
    }
}
