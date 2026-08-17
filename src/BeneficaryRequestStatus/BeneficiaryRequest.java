package BeneficaryRequestStatus;

import utility.State;

public class BeneficiaryRequest {
    private int RequestId ;
    private static int counter =0 ;
    private RequestState state ;
    private String request ;
    private int BeneficiaryId ;

    public BeneficiaryRequest(int beneficiaryId , String request) {
        counter++ ;
        BeneficiaryId = beneficiaryId;
        state = new NewState() ;
        this.request = request ;
        RequestId = counter ;
    }
    public RequestState GetState(){
        return this.state ;
    }

    public void SetState(RequestState state){
        this.state = state ;
    }

    public int getRequestId() {
        return RequestId;
    }

    public String getState() {
        return state.getStatus();
    }

    public String getRequest() {
        return request;
    }

    public int getBeneficiaryId() {
        return BeneficiaryId;
    }

    public void setRequestId(int requestId) {
        RequestId = requestId;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "BeneficiaryRequest{" +
                "RequestId=" + RequestId +
                ", state=" + state.getStatus() +
                ", request='" + request + '\'' +
                ", BeneficiaryId=" + BeneficiaryId +
                '}';
    }
}
