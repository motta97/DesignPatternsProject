package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;
import BeneficaryRequestStatus.BeneficiaryRequest;
import Commands.RegisterBeneficiaryUndoCommand;
import DonationManagement.Donation;
import Report.Report;
import Report.BeneficaryReport;
import utility.Command;

import java.util.List;

public class BeneficiaryFacade {

    private   BeneficiaryModel model;
    private Command slot ;

    public BeneficiaryFacade(BeneficiaryModel model) {

        this.model = model;
    }

    public Beneficiary registerBeneficiary(String name,  String phone, String email, String distributionType) {

        return model.registerBeneficiary(name,  phone, email, distributionType);
    }

    public Beneficiary addSupport(int beneficiaryId, String supportType) {

        return model.addSupport(beneficiaryId, supportType);
    }

    public Beneficiary changeDistributionStrategy(int beneficiaryId, String strategyType) {

        return model.changeDistributionStrategy(beneficiaryId, strategyType);
    }

    public void distributeDonation(int beneficiaryId, Donation donation, String strategyType) {

        model.distributeDonation(beneficiaryId, donation, strategyType);
    }

    public Beneficiary findBeneficiary(int beneficiaryId) {

        return model.findBeneficiaryById(beneficiaryId);
    }

    public List<Beneficiary> getAllBeneficiaries() {

        return model.getAllBeneficiaries();
    }
    public void SetCommand(Command ref){
        this.slot = ref ;
    }
    public void UndoRegisterBenefcairy(){
        SetCommand(new RegisterBeneficiaryUndoCommand(model));
        slot.Undo();
    }

    public List<BeneficiaryRequest> getAllRequests() {

        return model.getRequests();
    }

    public BeneficiaryRequest registerRequest(String request , int beneficiaryid){
        return model.registeRequest(request , beneficiaryid) ;
    }

    public BeneficiaryRequest findRquest(int id){
        return model.findRequestById(id) ;
    }

public void GenerateReport(){
            Report report = new BeneficaryReport(model) ;
            report.GenerateReport();
        }
    public void savechangesTorequestReposiotry(){
        model.savechangesTorequestReposiotry();
    }
}