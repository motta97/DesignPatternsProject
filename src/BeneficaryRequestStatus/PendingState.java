package BeneficaryRequestStatus;

public class PendingState implements RequestState{

    @Override
    public void approve(BeneficiaryRequest request) {
        request.SetState(new ApprovedState());
        System.out.println("[Pending State] moved to Approved State . . . . ");
    }

    @Override
    public void reject(BeneficiaryRequest request) {
        request.SetState(new RejectedState());
        System.out.println("[Pending State] moved to Rejected State . . . . ");
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
        return "Pending";
    }
}
