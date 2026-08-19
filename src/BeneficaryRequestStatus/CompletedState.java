package BeneficaryRequestStatus;

import TextFile.TextFileHandler;
import utility.txtGetter;

import java.util.List;

public class CompletedState implements RequestState{
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
        return "Completed";
    }
}
