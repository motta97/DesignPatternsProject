package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;
import DonationManagement.Donation;

import java.util.List;

public class BeneficiaryFacade {

    private final BeneficiaryModel model;

    public BeneficiaryFacade(BeneficiaryModel model) {

        this.model = model;
    }

    public Beneficiary registerBeneficiary(String name, int id, String phone, String email, String distributionType) {

        return model.registerBeneficiary(name, id, phone, email, distributionType);
    }

    public Beneficiary addSupport(int beneficiaryId, String supportType) {

        return model.addSupport(beneficiaryId, supportType);
    }

    public Beneficiary changeDistributionStrategy(int beneficiaryId, String strategyType) {

        return model.changeDistributionStrategy(beneficiaryId, strategyType);
    }

    public void distributeDonation(int beneficiaryId, Donation donation, String strategyType) {

        model.distributeDonation(beneficiaryId, donation, strategyType);
    }

    public Beneficiary findBeneficiary(int beneficiaryId) {

        return model.findBeneficiaryById(beneficiaryId);
    }

    public List<Beneficiary> getAllBeneficiaries() {

        return model.getAllBeneficiaries();
    }
}