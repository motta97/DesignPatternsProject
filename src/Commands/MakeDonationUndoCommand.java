package Commands;

import DonationMVC.DonationModel;
import DonationMVC.DonationView;
import utility.Command;

public class MakeDonationUndoCommand implements Command {
    private DonationModel model ;
    public MakeDonationUndoCommand(DonationModel model){
        this.model = model ;
    }
    @Override
    public void Undo() {
        model.RemoveDonationById(model.GetLastDonation().getId());
    }
}
