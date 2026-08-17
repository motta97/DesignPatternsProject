package BeneficaryRequestStatus;

public class InProgressState implements RequestState{
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
    public void processNew(BeneficiaryRequest request){
        System.out.println("Cannot Do this Transaction");
    }

    @Override
    public void complete(BeneficiaryRequest request) {
    request.SetState(new CompletedState());
        System.out.println("[In Progress State] moved to Complete State . . . . ");
    }



    @Override
    public String getStatus() {
        return "InProgress";
    }
}
