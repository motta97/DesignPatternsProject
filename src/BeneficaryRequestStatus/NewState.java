package BeneficaryRequestStatus;

public class NewState implements RequestState{
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
        request.SetState(new PendingState());
        System.out.println("[New State] moved to Pending State . . . . ");
    }

    @Override
    public String getStatus() {
        return "New";
    }
}
