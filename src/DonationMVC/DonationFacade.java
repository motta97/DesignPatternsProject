package DonationMVC;

import Commands.MakeDonationUndoCommand;
import Commands.RegisterDonorUndoCommand;
import DonationManagement.Donation;
import DonationManagement.Donor;
import Report.Report;
import Report.DonationReport;
import utility.Command;

import java.util.List;

public class DonationFacade {

    private   DonationModel model;
    private Command slot;

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

    public void UndoRegisterDonor(){
        SetCommand(new RegisterDonorUndoCommand(model));
        slot.Undo();
    }

    public void UndoMakeDonation(){
        SetCommand(new MakeDonationUndoCommand(model));
        slot.Undo();
    }
    public void GenerateReport(){

        Report report = new DonationReport(model) ;
        report.GenerateReport();
    }

}