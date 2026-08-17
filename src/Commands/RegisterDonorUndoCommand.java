package Commands;

import DonationMVC.DonationModel;
import utility.Command;

public class RegisterDonorUndoCommand implements Command {
    private DonationModel model ;
    public RegisterDonorUndoCommand(DonationModel model){
        this.model = model ;
    }

    @Override
    public void Undo() {
        model.RemoveDonorbyId(model.GetLastDonor().getId());
    }
}

