package BeneficiaryMVC;

import BeneficaryManagement.BeneficaryFactory;
import BeneficaryManagement.Beneficiary;
import BeneficaryManagement.DistributionStrategy;
import BeneficaryManagement.Isupport;
import DonationManagement.Donation;
import TextFile.BeneficiaryTextFileRepository;

import java.util.Collections;
import java.util.List;

public class BeneficiaryModel {

    private  BeneficiaryTextFileRepository repository;

    private  List<Beneficiary> beneficiaries;

    public BeneficiaryModel() {

        repository = new BeneficiaryTextFileRepository();

        beneficiaries = repository.loadAll();
    }

    public Beneficiary registerBeneficiary(String name, int id, String phone, String email, String distributionType) {

        if (findBeneficiaryOrNull(id) != null) {
            throw new IllegalArgumentException(
                    "Beneficiary ID already exists: " + id
            );
        }

            Beneficiary beneficiary = BeneficaryFactory.createBeneficary(name, id, phone, email, distributionType);

            beneficiaries.add(beneficiary);

            repository.saveAll(beneficiaries);

            return beneficiary;

    }
    public Beneficiary addSupport(int beneficiaryId, String supportType) {

        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);

        Isupport updatedSupport = BeneficaryFactory.createSupport(supportType, beneficiary.getSupp_type());

        beneficiary.setSupp_type(updatedSupport);

        repository.saveAll(beneficiaries);

        return beneficiary;
    }

    public Beneficiary changeDistributionStrategy(int beneficiaryId, String strategyType) {

        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);

        DistributionStrategy strategy = BeneficaryFactory.createDistributionStrategy(strategyType);

        beneficiary.setRef(strategy);

        repository.saveAll(beneficiaries);

        return beneficiary;
    }

    public void distributeDonation(int beneficiaryId, Donation donation, String strategyType) {

        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);

        DistributionStrategy strategy = BeneficaryFactory.createDistributionStrategy(strategyType);

        beneficiary.setRef(strategy);

        beneficiary.distributeDonation(donation);

        repository.saveAll(beneficiaries);
    }

    public Beneficiary findBeneficiaryById(int id) {

        Beneficiary beneficiary = findBeneficiaryOrNull(id);

        if (beneficiary == null) {

            throw new IllegalArgumentException("Beneficiary not found: " + id);
        }

        return beneficiary;
    }

    public List<Beneficiary>
    getAllBeneficiaries() {

        return beneficiaries;
    }

    private Beneficiary findBeneficiaryOrNull(
            int id) {

        for (Beneficiary beneficiary :
                beneficiaries) {

            if (beneficiary.getId() == id) {
                return beneficiary;
            }
        }

        return null;
    }
}