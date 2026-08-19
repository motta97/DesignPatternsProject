package BeneficaryRequestStatus;

import TextFile.TextFileHandler;
import utility.txtGetter;

import java.util.List;

public class PendingState implements RequestState{

    @Override
    public void approve(BeneficiaryRequest request) {
        request.SetState(new ApprovedState());
        System.out.println(txtGetter.getMessage("approvePending","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));
    }

    @Override
    public void reject(BeneficiaryRequest request) {

        request.SetState(new RejectedState());
        System.out.println(txtGetter.getMessage("rejectPending","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));

    }

    @Override
    public void startDistribution(BeneficiaryRequest request) {

        System.out.println(txtGetter.getMessage("ErrorMessage","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));
    }

    @Override
    public void complete(BeneficiaryRequest request) {

        System.out.println(txtGetter.getMessage("ErrorMessage","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));
    }
    @Override
    public void processNew(BeneficiaryRequest request){

        System.out.println(txtGetter.getMessage("ErrorMessage","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));
    }


    @Override
    public String getStatus() {
        return "Pending";
    }
}
