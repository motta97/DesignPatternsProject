package BeneficaryRequestStatus;

public class CompletedState implements RequestState{
    @Override
    public void approve(BeneficiaryRequest request) {
        System.out.println("Cannot Do this Transaction");
    }

    @Override
    public void reject(BeneficiaryRequest request) {
        System.out.println("Cannot Do this Transaction");
    }

    @Override
    public void startDistribution(BeneficiaryRequest request) {
        System.out.println("Cannot Do this Transaction");
    }

    @Override
    public void complete(BeneficiaryRequest request) {
        System.out.println("Cannot Do this Transaction");
    }
    @Override
    public void processNew(BeneficiaryRequest request){
        System.out.println("Cannot Do this Transaction");
    }


    @Override
    public String getStatus() {
        return "Completed";
    }
}
