package Commands;

import DonationMVC.DonationModel;
import DonationManagement.Donor;
import utility.Command;

public class RemoveLastDonorCommand implements Command {
    private DonationModel model ;
    private Donor ref ;
    public RemoveLastDonorCommand(DonationModel model){
        this.model = model ;
    }

    @Override
    public void execute() {
        ref = model.GetLastDonor() ;
        model.RemoveDonorbyId(model.GetLastDonor().getId());
    }

    @Override
    public void Undo() {
        if(ref != null){
            model.registerDonor(ref.getName(), ref.getType(), ref.getPhone(), ref.getEmail()) ;
        }

    }
}

