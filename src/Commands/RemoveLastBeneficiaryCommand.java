package Commands;

import BeneficaryManagement.Beneficiary;
import BeneficiaryMVC.BeneficiaryModel;
import utility.Command;

public class RemoveLastBeneficiaryCommand implements Command {
    private BeneficiaryModel model ;
    Beneficiary ref ;
    public RemoveLastBeneficiaryCommand(BeneficiaryModel model){
        this.model =model ;
    }

    @Override
    public void execute() {
        ref =model.GetLastBeneficiary() ;
       model.RemoveBeneficary(ref);
       model.getUserRepository().removeUser(ref);
    }

    @Override
    public void Undo() {
        if(ref != null){
            model.registerBeneficiary(ref.getName(), ref.getPhone(), ref.getEmail(), "collection") ;
        }

    }
}
