package DonationMVC;

import Commands.RemoveLastDonationCommand;
import Commands.RemoveLastDonorCommand;
import DonationManagement.Donation;
import DonationManagement.Donor;
import Report.Report;
import Report.DonationReport;
import utility.Command;

import java.util.List;

public class DonationFacade {

    private   DonationModel model;
    private Command slot = null ;

    public DonationFacade(DonationModel model) {

        this.model = model;
    }

    public Donor registerDonor(String name, String donorType, String phone, String email) {

        return model.registerDonor(name,  donorType, phone, email);
    }

    public Donation makeDonation(int donorId, String paymentMethod, String donationType, double value, String paymentDetails) {

        return model.makeDonation(donorId, paymentMethod, donationType, value, paymentDetails);
    }

    public Donor findDonor(int donorId) {

        return model.findDonorById(donorId);
    }

    public Donation findDonation(int donationId) {

        return model.findDonationById(donationId);
    }

    public List<Donor> getAllDonors() {

        return model.getAllDonors();
    }

    public List<Donation> getAllDonations() {

        return model.getAllDonations();
    }

    public void SetCommand(Command ref){
        slot = ref ;
    }

    public void RemoveLastDonor(){
        SetCommand(new RemoveLastDonorCommand(model));
        slot.execute();
    }

    public void RemoveLastDonation(){
        SetCommand(new RemoveLastDonationCommand(model));
        slot.execute();
    }
    public void UndoRemoveLastDonor(){
      if(slot != null){
          slot.Undo();
      } else{
          System.out.println("You have not make a command to undo it ");
      }

    }

    public void UndoRemoveLastDonation(){
        if(slot != null){
            slot.Undo();
        } else{
            System.out.println("You have not make a command to undo it ");
        }
    }
    public void GenerateReport(){

        Report report = new DonationReport(model) ;
        report.GenerateReport();
    }

}