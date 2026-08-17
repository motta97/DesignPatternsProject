package Commands;

import BeneficiaryMVC.BeneficiaryModel;
import utility.Command;

public class RegisterBeneficiaryUndoCommand implements Command {
    private BeneficiaryModel model ;
    public RegisterBeneficiaryUndoCommand(BeneficiaryModel model){
        this.model =model ;
    }

    @Override
    public void Undo() {
        model.removeBeneficiaryById(model.GetLastBeneficiary().getId());
    }
}
