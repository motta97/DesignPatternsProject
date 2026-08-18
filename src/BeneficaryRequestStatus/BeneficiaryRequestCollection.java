package BeneficaryRequestStatus;

import BeneficiaryMVC.BeneficiaryModel;

import java.util.List;

public class BeneficiaryRequestCollection implements RequestIteratableCollection {
   private List<BeneficiaryRequest> requests ;
   public BeneficiaryRequestCollection(List<BeneficiaryRequest> requests){
       this.requests =requests ;
   }
    @Override
    public RequestIterator CreateIterator() {
        return new AllRequestsIterator(this);
    }
    public int getSize(){
       return requests.size() ;
    }
    public BeneficiaryRequest getRequestAt(int index){
       return requests.get(index) ;
    }


}
