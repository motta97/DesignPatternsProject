package BeneficaryRequestStatus;

public interface RequestState {
    public void approve(BeneficiaryRequest request) ;
    public void reject(BeneficiaryRequest request) ;
    public void startDistribution(BeneficiaryRequest request) ;
    public void complete(BeneficiaryRequest request) ;
    public void processNew(BeneficiaryRequest request) ;
    public String getStatus() ;
}
