package BeneficaryRequestStatus;

public class ApprovedState implements RequestState{
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
    request.SetState(new InProgressState());
        System.out.println("[Approved State] moved to In Progress State . . . . ");
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
        return "Approved";
    }
}
