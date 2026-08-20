package TextFile;

import DonationManagement.*;

import java.util.ArrayList;
import java.util.List;

public class DonorRepository {
    private final  String fileName = "data/donors.txt" ;
    private TextFileHandler texthandler ;
    public DonorRepository(){
        texthandler = TextFileHandler.GetInstance() ;
    }

    public List<Donor> getAll(){

        List<Donor> Donors = new ArrayList<>() ;
        List<String> lines = texthandler.ReadFile(fileName) ;
        for(String line : lines){
            if(line.startsWith("#")){
                continue;
            }
            String[] fields = line.split("\\|") ;
            try{


                String name = fields[1];

                String phone = fields[2];

                String email = fields[3];

                String donorType =
                        fields[4];

                Donor donor = DonorFactory.createDonor(name, donorType, phone, email);


                Donors.add(donor);
            }
            catch (Exception exception) {


            }


            }
        return Donors ;
    }
    public void saveAll(List<Donor> donors) {
        List<String> lines =
                new ArrayList<>();

        lines.add("# id|name|phone|email|donorType");
        for (Donor donor : donors) {

            String line = donor.getId() + "|" + donor.getName() + "|" + donor.getPhone() + "|" + donor.getEmail() + "|";
            String donorType = getDonorType(donor) ;
            if(donorType == null){
                donorType = "basic" ;
            }
            line  = line + donorType ;
            lines.add(line);
        }
        texthandler.WriteLine(fileName,lines);
    }


    public String getDonorType(Donor donor) {

        if (donor instanceof VIPDonor) {
            return "vip";
        }

        if (donor instanceof PremiumDonor) {
            return "premium";
        }

        if (donor instanceof BasicDonor) {
            return "basic";
        }

    return "basic" ;
    }
}
