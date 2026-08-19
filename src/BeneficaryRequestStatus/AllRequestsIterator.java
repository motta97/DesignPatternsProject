package BeneficaryRequestStatus;

public class AllRequestsIterator implements RequestIterator {
    private BeneficiaryRequestCollection collection ;
    private int postion =0 ;
    public AllRequestsIterator(BeneficiaryRequestCollection collection){
        this.collection = collection ;
    }

    @Override
    public boolean hasNext() {
        return postion<collection.getSize();
    }

    @Override
    public BeneficiaryRequest next() {
        BeneficiaryRequest request = collection.getRequestAt(postion) ;
        postion++;
        return request;
    }
}
