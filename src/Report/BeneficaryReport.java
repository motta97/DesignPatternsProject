package Report;

import BeneficaryManagement.*;
import BeneficiaryMVC.BeneficiaryModel;
import DonationMVC.DonationModel;
import DonationManagement.Donation;

import java.util.ArrayList;
import java.util.List;

public class BeneficaryReport extends Report{
    private BeneficiaryModel model ;
    public BeneficaryReport(BeneficiaryModel model){
        this.model = model;
    }

    @Override
    public List<String> collectData() {
        List<String> lines = new ArrayList<>() ;

        for(Beneficiary beneficiary : model.getAllBeneficiaries()){
            String Line = "Beneficiary #"+Integer.toString(beneficiary.getId()) +"\n"
                    +"Name: "+beneficiary.getName()+"\n"
                    +"Support: "+beneficiary.getSupp_type().getSupport()+"\n"
                    +"Distribution: ";
            String Distrubtiontype  ;
            DistributionStrategy strategy = beneficiary.getRef() ;
            if(strategy instanceof DeliveryAdapter){
                Distrubtiontype = "External Delivery" ;
            }else if(strategy instanceof DigitalTransfer){
                Distrubtiontype = "Digital Transfer" ;
            }else if(strategy instanceof HomeDelivery){
                Distrubtiontype = "Home Delivery" ;
            }else {
                Distrubtiontype = "Collection" ;
            }
            Line =Line+Distrubtiontype ;
            lines.add(Line) ;
            lines.add("-------------------") ;
        }
        return lines ;
    }



    @Override
    public List<String> createSummary() {
        List<String> result = new ArrayList<>() ;
        result.add("Total Beneficaries: "+ model.getAllBeneficiaries().size()) ;
        result.add("Total Requests: "+model.getRequests().size()) ;

        return result ;
    }
}
