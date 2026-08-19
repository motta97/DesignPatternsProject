package Report;

import DonationMVC.DonationModel;
import DonationManagement.Donation;

import java.util.ArrayList;
import java.util.List;

public class DonationReport extends Report{

    private DonationModel model ;
    public DonationReport(DonationModel model){
        this.model = model;
    }

    @Override
    public List<String> collectData() {
        List<String> lines = new ArrayList<>() ;

        for(Donation donation : model.getAllDonations()){
            String Line = "Donation #"+Integer.toString(donation.getId()) +"\n"
                    +"Donor: "+donation.getDonor().getName()+"\n"
                    +"Type: "+donation.gettype()+"\n"
                    +"Amount/Qty: "+donation.getAmount() ;
                    lines.add(Line) ;
            lines.add("-------------------") ;
        }
        return lines ;
    }



    @Override
    public List<String> createSummary() {
        List<String> result = new ArrayList<>() ;
        result.add("Total Donations: "+ model.getAllDonations().size()) ;
        result.add("Total Donors: "+model.getAllDonors().size()) ;

           return result ;
    }
}
