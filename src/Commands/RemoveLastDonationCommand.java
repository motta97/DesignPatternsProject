package Commands;

import DonationMVC.DonationModel;
import DonationManagement.Donation;
import utility.Command;

public class RemoveLastDonationCommand implements Command {
    private DonationModel model ;
    private Donation ref ;
    public RemoveLastDonationCommand(DonationModel model){
        this.model = model ;
    }

    @Override
    public void execute() {
        ref =model.GetLastDonation() ;
        model.RemoveDonation(ref);
    }

    @Override
    public void Undo() {
        if(ref != null){
            model.makeDonation(ref.getDonor().getId(),ref.getMethod().getMethodType() ,ref.gettype(),ref.getAmount(),ref.getMethod().getPaymentDetails());
        }

    }
}
