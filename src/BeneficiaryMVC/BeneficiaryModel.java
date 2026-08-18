package BeneficiaryMVC;

import BeneficaryManagement.BeneficaryFactory;
import BeneficaryManagement.Beneficiary;
import BeneficaryManagement.DistributionStrategy;
import BeneficaryManagement.Isupport;
import BeneficaryRequestStatus.BeneficiaryRequest;
import DonationManagement.Donation;
import TextFile.BeneficiaryRepository;
import TextFile.BeneficiaryRequestsRepository;

import java.util.List;

public class BeneficiaryModel {


    private BeneficiaryRepository repository ;

    private BeneficiaryRequestsRepository requestsRepository ;

    private  List<Beneficiary> beneficiaries;

    private List<BeneficiaryRequest> requests ;

    public BeneficiaryModel() {

        repository = new BeneficiaryRepository();
        beneficiaries = repository.getAll();
        requestsRepository = new BeneficiaryRequestsRepository() ;

        requests = requestsRepository.getAll() ;


    }

    public Beneficiary registerBeneficiary(String name,  String phone, String email, String distributionType) {



            Beneficiary beneficiary = BeneficaryFactory.createBeneficary(name,  phone, email, distributionType);

            beneficiaries.add(beneficiary);

            repository.SaveAll(beneficiaries);

            return beneficiary;

    }
    public Beneficiary addSupport(int beneficiaryId, String supportType) {

        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);

        Isupport updatedSupport = BeneficaryFactory.createSupport(supportType, beneficiary.getSupp_type());

        beneficiary.setSupp_type(updatedSupport);

        repository.SaveAll(beneficiaries);

        return beneficiary;
    }
    public BeneficiaryRequest registeRequest(String request , int beneficiaryid){
        BeneficiaryRequest Request =BeneficaryFactory.createBeneficiaryRequest(request ,beneficiaryid) ;
        requests.add(Request) ;
        requestsRepository.SaveAll(requests);
        return Request ;
    }
    public BeneficiaryRequest findRequestById(int id){
       for(BeneficiaryRequest request : requests){
           if(request.getRequestId() == id){
               return request ;
           }
       }
       return null ;
    }

    public List<BeneficiaryRequest> getRequests(){
        return requests ;
    }

    public void RemoveBenficaryRequest(int requestid){
        BeneficiaryRequest ref = null ;
        for(BeneficiaryRequest request : requests){
            if(request.getBeneficiaryId() == requestid){
                ref = request ;
            }
        }
        if(ref != null){
            requests.remove(ref) ;
            requestsRepository.SaveAll(requests);
        }
        System.out.println("Not found this request");
    }

    public Beneficiary changeDistributionStrategy(int beneficiaryId, String strategyType) {

        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);

        DistributionStrategy strategy = BeneficaryFactory.createDistributionStrategy(strategyType);

        beneficiary.setRef(strategy);

        repository.SaveAll(beneficiaries);

        return beneficiary;
    }

    public void distributeDonation(int beneficiaryId, Donation donation, String strategyType) {

        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);

        DistributionStrategy strategy = BeneficaryFactory.createDistributionStrategy(strategyType);

        beneficiary.setRef(strategy);

        beneficiary.distributeDonation(donation);

        repository.SaveAll(beneficiaries);
    }


    public List<Beneficiary> getAllBeneficiaries() {

        return beneficiaries;
    }

    public Beneficiary findBeneficiaryById(int id) {

        for (Beneficiary beneficiary : beneficiaries) {

            if (beneficiary.getId() == id) {
                return beneficiary;
            }
        }

        return null;
    }

    public Beneficiary GetLastBeneficiary(){
        return beneficiaries.getLast() ;
    }
    public void removeBeneficiaryById(int id){
        Beneficiary ref = beneficiaries.get(--id) ;
        if(ref != null){
            beneficiaries.remove(ref) ;
            repository.SaveAll(beneficiaries);
        }else {
            System.out.println("Beneficiary Not found");
        }

    }
    public void savechangesTorequestReposiotry() {
        requestsRepository.SaveAll(requests);
    }
}