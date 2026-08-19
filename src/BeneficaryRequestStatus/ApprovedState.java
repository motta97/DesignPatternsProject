package BeneficaryRequestStatus;

import TextFile.TextFileHandler;
import utility.txtGetter;

import java.util.List;

public class ApprovedState implements RequestState{
    @Override
    public void approve(BeneficiaryRequest request) {

        System.out.println(txtGetter.getMessage("ErrorMessage","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));
    }

    @Override
    public void reject(BeneficiaryRequest request) {

        System.out.println(txtGetter.getMessage("ErrorMessage","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));

    }

    @Override
    public void startDistribution(BeneficiaryRequest request) {
    request.SetState(new InProgressState());

        System.out.println(txtGetter.getMessage("startDistributionApproved","src/BeneficaryRequestStatus/RequestStatusMessages.txt"));
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
        return "Approved";
    }
}
