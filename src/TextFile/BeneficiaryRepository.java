package TextFile;

import BeneficaryManagement.*;
import DonationManagement.Donation;
import DonationManagement.Donor;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryRepository {
    private final  String filePath = "data/beneficiaries.txt" ;
    private TextFileHandler texthandler ;
    public BeneficiaryRepository(){
        texthandler = TextFileHandler.GetInstance() ;
    }
    public List<Beneficiary> getAll() {
        List<Beneficiary> Beneficiaries = new ArrayList<>();
        List<String> Lines = texthandler.ReadFile(filePath);
        for (String line : Lines) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] parts = line.split("\\|" ,-1);
            try {
                int id = Integer.parseInt(parts[0]);

                String name = parts[1];

                String phone = parts[2];

                String email = parts[3];

                String supportsText = parts[4];

                String strategyType = parts[5];

                Beneficiary beneficiary = BeneficaryFactory.createBeneficary(name, phone, email, strategyType);
                if (!supportsText.isBlank()) {

                    String[] supports = supportsText.split(",");

                    for (String supportType : supports) {
                         Isupport createdSupport = BeneficaryFactory.createSupport(supportType.trim(), beneficiary.getSupp_type());
                         beneficiary.setSupp_type(createdSupport);
                    }




            }
                Beneficiaries.add(beneficiary);

            }catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return Beneficiaries;
    }

    public void SaveAll(List<Beneficiary> beneficiaries){
        List<String> lines = new ArrayList<>();

        lines.add("# id|name|phone|email|supports|distributionStrategy");
        for (Beneficiary beneficiary : beneficiaries) {
            String line = beneficiary.getId() + "|" + beneficiary.getName() + "|" + beneficiary.getPhone() + "|" + beneficiary.getEmail()+ "|" ;
            String[] support = beneficiary.getSupp_type().getSupport().split(",") ;
            String suppType = "Basic" ;
            for(String supp : support){

                suppType = suppType +supp.trim() ;
            }
            line =line+suppType+"|" ;
            String distrubteType ="collection" ;
            if (beneficiary.getRef() == null ) {

                distrubteType = "collection";
            }

            if (beneficiary.getRef() instanceof DigitalTransfer) {
                distrubteType = "transfer";
            }

            if (beneficiary.getRef() instanceof HomeDelivery) {
                distrubteType = "delivery";
            }
            if(beneficiary.getRef() instanceof DeliveryAdapter){
                distrubteType = "external";
            }
            line = line +distrubteType ;
            lines.add(line) ;
        }
        texthandler.WriteLine(filePath,lines);

    }

}
