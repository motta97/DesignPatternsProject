package TextFile;

import DonationManagement.*;

import java.util.ArrayList;
import java.util.List;

public class DonaitonRepository {
    private String filePath = "data/donations.txt" ;
    private TextFileHandler texthandler ;
    public DonaitonRepository(){
        texthandler = TextFileHandler.GetInstance() ;
    }
    public List<Donation> getAll(){
        List<Donation> Donations = new ArrayList<>() ;
        DonorRepository donorRepository = new DonorRepository() ;
        List<Donor> donors = donorRepository.getAll() ;
        List<String> Lines =texthandler.ReadFile(filePath) ;
        for(String line : Lines){
            if(line.startsWith("#")){
                continue;
            }
            try{
                String[] parts =line.split("\\|") ;
                Donor ref = null ;
                for(Donor donor : donors){
                    if(donor.getId() == Integer.parseInt(parts[0])){
                        ref = donor ;
                    }
                    throw new Exception("Not Found this Donor") ;
                }

                String donationType = parts[1];

                double value = Double.parseDouble(parts[2]);

                String paymentMethod = parts[3];

                String paymentDetails = parts[4];

                Donation donation =
                        DonationFactory.createDonation(ref, paymentMethod, donationType, value, paymentDetails);

                Donations.add(donation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return Donations;
    }

    public void saveAll(List<Donation> donations)
    {
        List<String> lines =
                new ArrayList<>();

        lines.add("# donorId|donationType|value|" + "paymentMethod|paymentDetails");
        for (Donation donation : donations){
            String line = donation.getDonor().getId() + "|" ;
            String paymentDetails = "" ;
            String DonationType = donation.getDonationType().getType() ;
            line = line + DonationType+"|" ;
            line = line + donation.getAmount()+"|";
            line = line+ donation.getMethod().getMethodType()+"|";
           switch (donation.getMethod().getMethodType()){
               case ("CheckMethod") -> {
                   if(donation.getMethod() instanceof CheckMethod ){
                       paymentDetails = ((CheckMethod) donation.getMethod()).getCheckNumber() ;
                   }
               }
               case ("onlineMethod") -> {
                   if(donation.getMethod() instanceof onlineMethod){
                       paymentDetails = ((onlineMethod) donation.getMethod()).getCreditCardNumber() ;
                   }
               }
           }
            line = line+ paymentDetails;

           lines.add(line) ;



        }
        texthandler.WriteLine(filePath,lines);
    }


}
